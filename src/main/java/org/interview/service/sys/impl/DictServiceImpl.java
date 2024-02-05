package org.interview.service.sys.impl;

import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.interview.common.BusinessException;
import org.interview.entity.sys.Dict;
import org.interview.mapper.sys.DictMapper;
import org.interview.service.sys.DictService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Author      : Hullson
 * @Date        : create in 2024-02-05
 * @Description : 字典管理业务层
 */
@Service
@Slf4j
public class DictServiceImpl extends ServiceImpl<DictMapper, Dict> implements DictService {

    /**
     * 新增字典
     * @param dict  字典实体
     */
    @Override
    public void saveDict(Dict dict, HttpServletRequest request) {
        if (dict == null) {
            throw new BusinessException(500, "字典信息不能为空");
        }
        HttpSession session = request.getSession();
        String userId = (String) session.getAttribute("userId");
        dict.setCreateBy(userId);
        dict.setUpdateBy(userId);
        dict.preInsert();
        baseMapper.insert(dict);
    }

    /**
     * 删除字典
     * @param id    字典ID
     */
    @Override
    public void delDict(String id) {
        if (StringUtils.isBlank(id)) {
            throw new BusinessException(500, "ID不能为空");
        }
        baseMapper.delDict(id);
    }

    /**
     * 更新字典
     * @param dict      字典信息
     * @param request   请求Request域
     */
    @Override
    public void updateDict(Dict dict, HttpServletRequest request) {
        if (dict == null) {
            throw new BusinessException(500, "修改字典不能为空");
        }
        dict.preUpdate();
        HttpSession session = request.getSession();
        String userId = (String) session.getAttribute("userId");
        dict.setUpdateBy(userId);
        baseMapper.updateById(dict);
    }

    /**
     * 获取字典列表（分页）
     * @param dict      字典实体类
     * @param pageNum   页码
     * @param pageSize  分页大小
     * @return          字典列表
     */
    @Override
    public Page<Dict> listPage(Dict dict, Integer pageNum, Integer pageSize) {
        if (dict == null) {
            dict = new Dict();
        }
        Page<Dict> page = new Page<>(pageNum, pageSize);
        if (CollectionUtils.isEmpty(dict.getOrders())) {
            OrderItem orderItem = new OrderItem();
            orderItem.setColumn("a.create_date");
            orderItem.setAsc(false);
            dict.setOrders(Lists.newArrayList(orderItem));
        }
        page.setOrders(dict.getOrders());
        page.setRecords(baseMapper.listPage(page, dict));
        return page;
    }

    /**
     * 根据字典类型获取字典列表
     * @param type  字典类型
     * @return      字典列表
     */
    @Override
    public List<Dict> getListByType(String type) {
        return baseMapper.getListByType(type);
    }

    /**
     * 根据字典标签获取字典列表
     * @param label     字典标签
     * @return          字典列表
     */
    @Override
    public List<Dict> getListByLabel(String label) {
        return baseMapper.getListByLabel(label);
    }

    /**
     * 根据字典值获取字典列表
     * @param value     字典值
     * @return          字典列表
     */
    @Override
    public Dict getDictByValue(String value) {
        return baseMapper.getDictByValue(value);
    }
}
