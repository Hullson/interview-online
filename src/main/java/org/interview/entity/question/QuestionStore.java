package org.interview.entity.question;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.interview.common.DataEntity;

/**
 * @Author      : Hullson
 * @Date        : create in 2024-02-04
 * @Description : 面试题库实体类
 */

@Data
@NoArgsConstructor
@Accessors(chain = true)
@TableName("question_store")
public class QuestionStore extends DataEntity {
    private String type;            // 题目类型
    private String module;          // 所属模块
    private String tags;            // 题目标签
    private String title;           // 题目标题
    private String content;         // 题目内容
    private String imagePath;       // 图片路径
    private String codeType;        // 代码语言类型
    private String codeContent;     // 代码内容
}
