package org.interview.controller.test;

import lombok.extern.slf4j.Slf4j;
import org.interview.common.R;
import org.interview.common.ResultUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @Author      : Hullson
 * @Date        : create in 2024-02-04
 * @Description : 项目测试控制层
 */

@RestController
@RequestMapping("/test")
@Slf4j
public class TestController {

    @GetMapping("connect")
    public R test() {
        return ResultUtils.success("connect success");
    }

    @GetMapping("getSessionId")
    public String getSessionId(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String userId = (String) session.getAttribute("userId");
        log.info(" ----> userId: {}", userId);
        return userId;
    }
}
