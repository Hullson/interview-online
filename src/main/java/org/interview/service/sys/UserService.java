package org.interview.service.sys;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import org.interview.entity.sys.User;

import javax.servlet.http.HttpServletRequest;

public interface UserService extends IService<User> {
    User login(User user, HttpServletRequest request);
    void saveUser(User user);
    void delUser(String id);
    void updateUser(User user);

    Page<User> listPage(User user, Integer pageNum, Integer pageSize);
    User getUserByAccount(String loginAccount);

}
