package org.interview.entity.sys;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.interview.common.DataEntity;

/**
 * @Author      : Hullson
 * @Date        : create in 2024-02-04
 * @Description : 系统字典管理实体类
 */

@Data
@NoArgsConstructor
@TableName("sys_dict")
public class Dict extends DataEntity {
    private String label;           // 字典标签
    private String value;           // 字典值
    private String type;            // 字典类型
    private Integer sort;           // 排序
    private String description;     // 字典描述

}
