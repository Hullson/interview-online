package org.interview.mapper.question;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.interview.entity.question.QuestionStore;

import java.util.List;

public interface QuestionStoreMapper extends BaseMapper<QuestionStore> {
    void updateQuestion(@Param("question") QuestionStore questionStore);
    void deleteQuestion(@Param("id") String id);

    List<QuestionStore> listPage(Page<QuestionStore> questionStorePage,
                                 @Param("question")QuestionStore questionStore);

}
