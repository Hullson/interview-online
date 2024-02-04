package org.interview.entity.question;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.interview.common.DataEntity;

/**
 * @Author      : Hullson
 * @Date        : create in 2024-02-04
 * @Description : 选项库实体类
 */

@Data
@NoArgsConstructor
@TableName("option_store")
public class OptionStore extends DataEntity {
    private String questionId;      // 题目ID
    private String optionContent;   // 选项内容
    private String isRight;         // 是否正确
}
