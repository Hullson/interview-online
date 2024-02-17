package org.interview.service.resume;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import org.interview.entity.resume.ResumeFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface ResumeFileService extends IService<ResumeFile> {
    void delResumeFile(String id);
    Page<ResumeFile> listPage(ResumeFile resumeFile, Integer pageNum, Integer pageSize);
    void bindResume2User(ResumeFile resumeFileVo);
    void exportResumeFile(String resumeId, HttpServletRequest request, HttpServletResponse response) throws IOException;

}
