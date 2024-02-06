package org.interview.entity.resume;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.interview.common.DataEntity;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Author      : Hullson
 * @Date        : create in 2024-02-04
 * @Description : 简历文件实体类
 */

@Data
@NoArgsConstructor
@TableName("resume_file")
public class ResumeFile extends DataEntity {
    private String userId;        // 所属用户ID
    private String userName;            // 用户名
    private String tags;                // 标签
    private String filePath;            // 文件路径
    private String fileName;            // 文件名称
    private String fileType;            // 文件类型
    private Long fileSize;              // 文件大小
    private String fileResource;        // 文件来源

    @TableField(exist = false)
    private MultipartFile file;
}
