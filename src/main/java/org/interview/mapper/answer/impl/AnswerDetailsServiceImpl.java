package org.interview.mapper.answer.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.interview.entity.answer.AnswerDetails;
import org.interview.mapper.answer.AnswerDetailsMapper;
import org.interview.service.answer.AnswerDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author      : Hullson
 * @Date        : create in 2024-02-12
 * @Description : 作答详情业务层
 */
@Service
@Slf4j
public class AnswerDetailsServiceImpl extends ServiceImpl<AnswerDetailsMapper, AnswerDetails> implements AnswerDetailsService {
    @Override
    public List<AnswerDetails> getListByRecord(String recordId) {
        return baseMapper.getListByRecord(recordId);
    }

    @Override
    public List<AnswerDetails> getListByUser(String userId) {
        return baseMapper.getListByUser(userId);
    }

    @Override
    public List<AnswerDetails> getListByQuestion(String questionId) {
        return baseMapper.getListByQuestion(questionId);
    }
}
