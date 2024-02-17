package org.interview.service.question.impl;

import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.interview.entity.question.OptionStore;
import org.interview.entity.question.QuestionStore;
import org.interview.mapper.question.QuestionStoreMapper;
import org.interview.service.question.QuestionStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @Author      : Hullson
 * @Date        : create in 2024-02-12
 * @Description : 题目库业务层
 */
@Service
@Slf4j
public class QuestionStoreServiceImpl extends ServiceImpl<QuestionStoreMapper, QuestionStore> implements QuestionStoreService {
    @Autowired
    private OptionStoreServiceImpl optionStoreService;
    @Override
    @Transactional
    public void saveQuestion(QuestionStore questionStore, List<String> options, Integer rightIndex) {
        questionStore.preInsert();
        String questionId = questionStore.getId();
        for (String option : options) {
            OptionStore optionStore = new OptionStore();
            optionStore.setQuestionId(questionId)
                        .setOptionContent(option)
                        .setIsRight("0");
            if (option.equals(options.get(rightIndex))) {
                optionStore.setIsRight("1");
            }
            optionStore.preInsert();
            optionStoreService.save(optionStore);
        }
        baseMapper.insert(questionStore);

    }

    @Override
    public void updateQuestion(QuestionStore questionStore) {
        baseMapper.updateQuestion(questionStore);
    }

    @Override
    public void deleteQuestion(String id) {
        baseMapper.deleteQuestion(id);
    }

    @Override
    public Page<QuestionStore> listPage(QuestionStore questionStore, Integer pageNum, Integer pageSize) {
        if (questionStore == null) {
            questionStore = new QuestionStore();
        }
        Page<QuestionStore> page = new Page<>(pageNum, pageSize);
        if (CollectionUtils.isEmpty(questionStore.getOrders())) {
            OrderItem orderItem = new OrderItem();
            orderItem.setColumn("a.create_date");
            orderItem.setAsc(false);
            questionStore.setOrders(Lists.newArrayList(orderItem));
        }
        page.setOrders(questionStore.getOrders());
        page.setRecords(baseMapper.listPage(page, questionStore));
        return page;
    }
}
