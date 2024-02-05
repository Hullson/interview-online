package org.interview.mapper.sys;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.interview.entity.sys.User;

import java.util.List;

public interface UserMapper extends BaseMapper<User> {
    void delUser(@Param("id") String id);
    void updateUser(@Param("user") User user);
    User login(@Param("user")User user);

    List<User> listPage(Page<User> page, @Param("user")User user);
    User getUserByAccount(@Param("loginAccount") String loginAccount);

}
