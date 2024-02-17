package org.interview.entity.answer;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.interview.common.DataEntity;

/**
 * @Author      : Hullson
 * @Date        : create in 2024-02-04
 * @Description : 作答详情实体类
 */

@Data
@NoArgsConstructor
@Accessors(chain = true)
@TableName("answer_details")
public class AnswerDetails extends DataEntity {
    private String userId;          // 用户ID
    private String recordId;        // 记录ID
    private String questionID;      // 问题ID
    private String questionTitle;   // 问题标题
    private String answerContent;   // 作答内容
    private String answerStatus;    // 作答状态
    private String codeType;        // 代码语言类型
    private String codeContent;     // 代码内容
}
