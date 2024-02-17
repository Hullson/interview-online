package org.interview.mapper.resume;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.interview.entity.resume.ResumeFile;

import java.util.List;

public interface ResumeFileMapper extends BaseMapper<ResumeFile> {

    void delResumeFile(@Param("id") String id);
    List<ResumeFile> listPage(Page<ResumeFile> page, @Param("resumeFile") ResumeFile resumeFile);

}
