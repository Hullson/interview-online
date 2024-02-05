package org.interview.controller.sys;

import org.interview.common.R;
import org.interview.common.ResultUtils;
import org.interview.entity.sys.User;
import org.interview.service.sys.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author      : Hullson
 * @Date        : create in 2024-02-05
 * @Description : 系统管理控制层
 */

@RestController
@RequestMapping("/sys")
public class SysController {
    @Autowired
    private UserServiceImpl userService;
    @PostMapping("login")
    public R login(@RequestBody User user, HttpServletRequest request) {
        return ResultUtils.success(userService.login(user, request));
    }
}
