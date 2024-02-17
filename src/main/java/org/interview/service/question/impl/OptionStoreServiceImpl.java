package org.interview.service.question.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.interview.entity.question.OptionStore;
import org.interview.mapper.question.OptionStoreMapper;
import org.interview.service.question.OptionStoreService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author      : Hullson
 * @Date        : create in 2024-02-12
 * @Description : 选项库业务层
 */
@Service
@Slf4j
public class OptionStoreServiceImpl extends ServiceImpl<OptionStoreMapper, OptionStore> implements OptionStoreService {
    @Override
    public void updateOptionStore(OptionStore optionStore) {
        baseMapper.updateOption(optionStore);
    }

    @Override
    public void deleteOptionStore(String id) {
        baseMapper.deleteOption(id);
    }

    @Override
    public List<OptionStore> getListByQuestion(String questionId) {
        return baseMapper.getListByQuestion(questionId);
    }
}
