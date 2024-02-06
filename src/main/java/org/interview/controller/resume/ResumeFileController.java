package org.interview.controller.resume;

import org.interview.common.R;
import org.interview.common.ResultUtils;
import org.interview.entity.resume.ResumeFile;
import org.interview.service.resume.impl.ResumeFileServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author      : Hullson
 * @Date        : create in 2024-02-06
 * @Description : 简历文件实体类
 */
@RestController
@RequestMapping("/resumeFile")
public class ResumeFileController {

    @Autowired
    private ResumeFileServiceImpl resumeFileService;

    @GetMapping("del/{id}")
    public R delResumeFile(@PathVariable("id") String id) {
        resumeFileService.delResumeFile(id);
        return ResultUtils.success();
    }

    @PostMapping("listPage")
    public R listPage(@RequestParam("pageNum") Integer pageNum,
                      @RequestParam("pageSize") Integer pageSize,
                      @RequestBody ResumeFile resumeFile) {
        return ResultUtils.success(resumeFileService.listPage(resumeFile, pageNum, pageSize));
    }

    @PostMapping("bindResumeFile")
    public R bindResumeFile2User(@ModelAttribute ResumeFile resumeFile) {
        resumeFileService.bindResume2User(resumeFile);
        return ResultUtils.success();
    }
}
