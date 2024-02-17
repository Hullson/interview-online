package org.interview.service.question;

import com.baomidou.mybatisplus.extension.service.IService;
import org.interview.entity.question.OptionStore;

import java.util.List;

public interface OptionStoreService extends IService<OptionStore> {
    void updateOptionStore(OptionStore optionStore);
    void deleteOptionStore(String id);
    List<OptionStore> getListByQuestion(String questionId);
}
