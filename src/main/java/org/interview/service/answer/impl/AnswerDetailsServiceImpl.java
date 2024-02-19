package org.interview.service.answer.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.interview.entity.answer.AnswerDetails;
import org.interview.mapper.answer.AnswerDetailsMapper;
import org.interview.service.answer.AnswerDetailsService;

import java.util.List;

/**
 * @Author : Hullson
 * @Date : create in 20xx-xx-xx
 * @Description : 描述
 */
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
