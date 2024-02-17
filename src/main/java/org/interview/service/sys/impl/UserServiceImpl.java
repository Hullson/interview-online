package org.interview.service.sys.impl;

import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.interview.common.BusinessException;
import org.interview.entity.sys.User;
import org.interview.mapper.sys.UserMapper;
import org.interview.service.sys.UserService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * @Author      : Hullson
 * @Date        : create in 2024-02-05
 * @Description : 系统用户管理业务层
 */

@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    /**
     * 用户登录
     * @param user      用户实体类
     * @param request   请求Request域
     * @return          返回登录用户信息
     */
    @Override
    // todo 修改为SpringSecurity权限认证
    public User login(User user, HttpServletRequest request) {
        if (StringUtils.isBlank(user.getLoginAccount())) {
            throw new BusinessException(500, "登录账号不能为空");
        }
        if (StringUtils.isBlank(user.getPassword())) {
            throw new BusinessException(500, "登录密码不能为空");
        }
        // todo 新增密码密文对比
        User loginUser = baseMapper.login(user);
        if (loginUser == null) {
            throw new BusinessException(500, "登录失败，用户不存在");
        }
        loginUser.setPassword(null);
        loginUser.setLastLoginTime(new Date());
        loginUser.preUpdate();
        baseMapper.updateById(loginUser);
        HttpSession session = request.getSession();
        session.setAttribute("userId", loginUser.getId());
        return loginUser;
    }

    /**
     * 新增用户
     * @param user      用户实体类
     */
    @Override
    public void saveUser(User user) {
        log.info(" ----> 用户名: {}", user.getUserName());
        log.info(" ----> 登录账号: {}", user.getPassword());
        // 判断新增用户信息
        if (StringUtils.isBlank(user.getLoginAccount())) {
            throw new BusinessException(500, "登录账号不能为空");
        }
        if (StringUtils.isBlank(user.getUserName())) {
            throw new BusinessException(500, "用户名不能为空");
        }
        if (StringUtils.isBlank(user.getPassword())) {
            throw new BusinessException(500, "用户密码不能为空");
        }

        // 获取登录账号
        String loginAccount = user.getLoginAccount();
        // 判断是否存在账号
        // todo 自动修改账号  账号 + 个数
        User existUser = this.getUserByAccount(loginAccount);
        if (existUser != null) {
            throw new BusinessException(500, "账号已存在");
        }
        // todo 密码加密
        user.setParentId("0");
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        HttpSession session = request.getSession();
        String userId = (String)session.getAttribute("userId");
        if ("2".equals(user.getType())) {
            user.setParentId(userId);
        }
        if (!"2".equals(user.getType()) && user.getExpireDuration() == 0) {
            user.setExpireDuration(-1);
        }
        user.preInsert();
        baseMapper.insert(user);
        log.info(" ----> 新增用户 {} 成功", user.getUserName());
    }

    /**
     * 删除用户
     * @param id 用户ID
     */
    @Override
    public void delUser(String id) {
        if (StringUtils.isBlank(id)) {
            throw new BusinessException(500, "用户ID不能为空");
        }
        baseMapper.delUser(id);
    }

    /**
     * 修改用户信息
     * @param user      用户实体类
     */
    @Override
    public void updateUser(User user) {
        if (user == null) {
            throw new BusinessException(500, "修改用户不能为空");
        }
        user.preUpdate();
        baseMapper.updateById(user);
    }

    /**
     * 获取用户列表（分页）
     * @param user      用户实体类
     * @param pageNum   页码
     * @param pageSize  分页大小
     * @return          用户列表
     */
    @Override
    public Page<User> listPage(User user, Integer pageNum, Integer pageSize) {
        if (user == null) {
            user = new User();
        }
        Page<User> page = new Page<>(pageNum, pageSize);
        if (CollectionUtils.isEmpty(user.getOrders())) {
            OrderItem orderItem = new OrderItem();
            orderItem.setColumn("a.create_date");
            orderItem.setAsc(false);
            user.setOrders(Lists.newArrayList(orderItem));
        }
        page.setOrders(user.getOrders());
        page.setRecords(baseMapper.listPage(page, user));
        return page;
    }

    /**
     * 根据账号获取用户信息
     * @param loginAccount  用户账号
     * @return              用户信息
     */
    @Override
    public User getUserByAccount(String loginAccount) {
        return baseMapper.getUserByAccount(loginAccount);
    }
}
