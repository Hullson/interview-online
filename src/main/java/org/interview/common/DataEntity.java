package org.interview.common;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.interview.utils.GenerateID;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @Author      : Hullson
 * @Date        : created in 2024-02-04
 * @Description : 通用实体类
 */
// 一切实体类都需要实例化
@Data
@NoArgsConstructor
public class DataEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    private static final String DEL_NORMAL = "0";
    private static final String DEL_REMOVE = "1";

    private String id;
    private String createBy;
    private Date createDate;
    private String updateBy;
    private Date updateDate;
    private String delFlag;
    private String remarks;
    @TableField(exist = false)
    private List<OrderItem> orders;

    public DataEntity(String id) {
        this();
        this.id = id;
    }

    public void preInsert() {
        if (StringUtils.isEmpty(this.id)) {
            setId(GenerateID.generateUUID());
        }
        HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest();
        HttpSession session = request.getSession();
        String userId = (String)session.getAttribute("userId");
        System.out.println(" ----> 用户信息：" + userId);
        this.setCreateBy(userId);
        this.setUpdateBy(userId);
        this.setCreateDate(new Date());
        this.setUpdateDate(new Date());
        this.delFlag = DEL_NORMAL;
    }

    public void preUpdate() {
        HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest();
        HttpSession session = request.getSession();
        String userId = (String)session.getAttribute("userId");
        this.setUpdateBy(userId);
        this.setUpdateDate(new Date());
    }
}
