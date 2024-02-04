package org.interview.entity.answer;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.interview.common.DataEntity;

/**
 * @Author      : Hullson
 * @Date        : create in 2024-02-04
 * @Description : 作答记录实体类
 */

@Data
@NoArgsConstructor
@TableName("answer_records")
public class AnswerRecords extends DataEntity {
    private String userId;              // 用户ID
    private String answerName;          // 作答名称
    private String answerDuration;      // 作答时长
    private String questionModule;      // 题目模块
    private Integer questionCount;      // 题目数量
    private Integer rightCount;         // 正确数量
    private Integer errorCount;         // 错误数量
    private Integer unanswerCount;      // 未作答数量
    private String isPass;              // 是否通过
}
