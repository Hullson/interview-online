package org.interview.mapper.answer;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.interview.entity.answer.AnswerDetails;

import java.util.List;

public interface AnswerDetailsMapper extends BaseMapper<AnswerDetails> {
    List<AnswerDetails> getListByRecord(@Param("recordId") String recordId);
    List<AnswerDetails> getListByUser(@Param("userId") String userId);
    List<AnswerDetails> getListByQuestion(@Param("questionId") String questionId);


}
