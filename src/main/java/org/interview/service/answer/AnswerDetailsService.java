package org.interview.service.answer;

import com.baomidou.mybatisplus.extension.service.IService;
import org.interview.entity.answer.AnswerDetails;

import java.util.List;

public interface AnswerDetailsService extends IService<AnswerDetails> {
    List<AnswerDetails> getListByRecord(String recordId);
    List<AnswerDetails> getListByUser(String userId);
    List<AnswerDetails> getListByQuestion(String questionId);
}
