package org.interview.mapper.question;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.interview.entity.question.OptionStore;

import java.util.List;

public interface OptionStoreMapper extends BaseMapper<OptionStore> {
    void updateOption(@Param("options") OptionStore optionStore);
    void deleteOption(@Param("id") String id);
    List<OptionStore> getListByQuestion(@Param("questionId") String questionId);

}
