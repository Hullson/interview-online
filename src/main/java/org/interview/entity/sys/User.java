package org.interview.entity.sys;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.interview.common.DataEntity;

import java.util.Date;

/**
 * @Author      : Hullson
 * @Date        : create in 2024-02-04
 * @Description : 系统用户管理实体类
 */

@Data
@NoArgsConstructor
@TableName("sys_user")
public class User extends DataEntity {
    private String parentId;            // 父账号ID
    private String loginAccount;        // 登录账号
    private String password;            // 密码
    private String userName;            // 用户名
    private String phone;               // 手机号码
    private String gender;              // 性别
    private String type;                // 账号类型
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date lastLoginTime;         // 最后登录时间
    private Integer expireDuration;     // 超时时长
}
