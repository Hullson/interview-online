package org.interview.common;

import com.baomidou.mybatisplus.core.metadata.OrderItem;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.interview.utils.GenerateID;

import java.util.Date;
import java.util.List;

/**
 * @Author      : Hullson
 * @Date        : created in 2024-02-04
 * @Description : 通用实体类
 */
@Data
@NoArgsConstructor
public class DataEntity {

    private static final long serialVersionUID = 1L;

    private static final String DEL_NORMAL = "0";
    private static final String DEL_REMOVE = "1";

    private String id;
    private String createBy;
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createDate;
    private String updateBy;
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateDate;
    private String delFlag;
    private String remark;

    private List<OrderItem> orders;

    public DataEntity(String id) {
        this();
        this.id = id;
    }

    public void preInsert() {
        if (StringUtils.isEmpty(this.id)) {
            setId(GenerateID.generateUUID());
        }
        this.setCreateDate(new Date());
        this.setUpdateDate(new Date());
        this.delFlag = DEL_NORMAL;
    }

    public void preUpdate() {
        this.setUpdateDate(new Date());
    }
}
