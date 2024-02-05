package org.interview.controller.sys;

import org.interview.common.R;
import org.interview.common.ResultUtils;
import org.interview.entity.sys.Dict;
import org.interview.service.sys.impl.DictServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author      : Hullson
 * @Date        : create in 2024-02-05
 * @Description : 字典管理控制层
 */

@RestController
@RequestMapping("/dict")
public class DictController {

    @Autowired
    private DictServiceImpl dictService;

    @PostMapping("save")
    public R saveDict(@RequestBody Dict dict, HttpServletRequest request) {
        dictService.saveDict(dict, request);
        return ResultUtils.success();
    }

    @DeleteMapping("del/{id}")
    public R delDict(@PathVariable("id") String id) {
        dictService.delDict(id);
        return ResultUtils.success();
    }

    @PutMapping("update")
    public R updateDict(@RequestBody Dict dict, HttpServletRequest request) {
        dictService.updateDict(dict, request);
        return ResultUtils.success();
    }

    @PostMapping("listPage")
    public R listPage(@RequestParam("pageNum") Integer pageNum,
                      @RequestParam("pageSize") Integer pageSize,
                      @RequestBody Dict dict) {
        return ResultUtils.success(dictService.listPage(dict, pageNum, pageSize));
    }

    @GetMapping("getListByType")
    public R getListByType(@RequestParam("type") String type) {
        return ResultUtils.success(dictService.getListByType(type));
    }

    @GetMapping("getListByLabel")
    public R getListByLabel(@RequestParam("label") String label) {
        return ResultUtils.success(dictService.getListByLabel(label));
    }

    @GetMapping("getListByValue")
    public R getListByValue(@RequestParam("value") String value) {
        return ResultUtils.success(dictService.getDictByValue(value));
    }

}
