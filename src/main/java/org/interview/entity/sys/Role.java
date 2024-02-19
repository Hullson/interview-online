package org.interview.entity.sys;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.interview.common.DataEntity;

/**
 * @Author      : Hullson
 * @Date        : create in 2024-02-10
 * @Description : 系统角色管理实体类
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
@TableName("sys_role")
public class Role extends DataEntity {
    private String roleName;        // 角色名称
    private String roleType;        // 角色类型
    private String roleIdentify;    // 角色标识
    private Integer sort;           // 排序
}
