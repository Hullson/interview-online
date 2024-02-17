package org.interview.service.question;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import org.interview.entity.question.QuestionStore;

import java.util.List;

public interface QuestionStoreService extends IService<QuestionStore> {
    void saveQuestion(QuestionStore questionStore, List<String> options, Integer rightIndex);
    void updateQuestion(QuestionStore questionStore);
    void deleteQuestion(String id);
    Page<QuestionStore> listPage(QuestionStore questionStore, Integer pageNum, Integer pageSize);
}
