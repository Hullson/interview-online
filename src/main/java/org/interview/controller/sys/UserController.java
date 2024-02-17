package org.interview.controller.sys;

import org.interview.common.R;
import org.interview.common.ResultUtils;
import org.interview.entity.sys.User;
import org.interview.service.sys.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author      : Hullson
 * @Date        : create in 2024-02-05
 * @Description : 系统用户管理控制层
 */

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    @PostMapping("save")
    public R saveUser(@RequestBody User user) {
        userService.saveUser(user);
        return ResultUtils.success();
    }

    @DeleteMapping("del/{id}")
    public R delUser(@PathVariable("id") String id) {
        userService.delUser(id);
        return ResultUtils.success();
    }

    @PutMapping("update")
    public R updateUser(@RequestBody User user) {
        userService.updateUser(user);
        return ResultUtils.success();
    }

    @PostMapping("listPage")
    public R listPage(@RequestParam("pageNum") Integer pageNum,
                      @RequestParam("pageSize") Integer pageSize,
                      @RequestBody User user) {
        return ResultUtils.success(userService.listPage(user, pageNum, pageSize));
    }
}
