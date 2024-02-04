package org.interview.controller.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author      : Hullson
 * @Date        : create in 2024-02-04
 * @Description : 项目测试控制层
 */

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("test")
    public String test() {
        return "connect success";
    }
}
