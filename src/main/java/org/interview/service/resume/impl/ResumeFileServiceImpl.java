package org.interview.service.resume.impl;

import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.interview.common.BusinessException;
import org.interview.entity.resume.ResumeFile;
import org.interview.mapper.resume.ResumeFileMapper;
import org.interview.service.resume.ResumeFileService;
import org.interview.utils.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

/**
 * @Author      : Hullson
 * @Date        : create in 2024-02-06
 * @Description : 简历文件业务层
 */
@Service
@Slf4j
public class ResumeFileServiceImpl extends ServiceImpl<ResumeFileMapper, ResumeFile> implements ResumeFileService {

    @Value("${resume-file.path}")
    private String filePath;
    /**
     * 删除简历文件
     * @param id    文件ID
     */
    @Override
    public void delResumeFile(String id) {
        if (StringUtils.isBlank(id)) {
            throw new BusinessException(500, "删除文件不能为空");
        }
        baseMapper.delResumeFile(id);
    }

    /**
     * 获取简历文件列表（分页）
     * @param resumeFile    简历文件实体
     * @param pageNum       页码
     * @param pageSize      分页大小
     * @return              简历文件列表
     */
    @Override
    public Page<ResumeFile> listPage(ResumeFile resumeFile, Integer pageNum, Integer pageSize) {
        if (resumeFile == null) {
            resumeFile = new ResumeFile();
        }
        Page<ResumeFile> page = new Page<>(pageNum, pageSize);
        if (CollectionUtils.isEmpty(resumeFile.getOrders())) {
            OrderItem orderItem = new OrderItem();
            orderItem.setColumn("create_date");
            orderItem.setAsc(false);
            resumeFile.setOrders(Lists.newArrayList(orderItem));
        }
        page.setOrders(resumeFile.getOrders());
        page.setRecords(baseMapper.listPage(page, resumeFile));
        return page;
    }

    /**
     * 绑定简历与用户关系
     * @param resumeFile  简历文件传输实体
     */
    @Override
    public void bindResume2User(ResumeFile resumeFile) {
        // todo 新增文件细节判断
        if (resumeFile.getFile() == null) {
            throw new BusinessException(500, "上传简历文件为空");
        }
        MultipartFile multipartFile = resumeFile.getFile();
        String fileName = FileUtils.getFileName(multipartFile);
        // todo 新增文件名生成 + 数字 防止重复
        String newFileName = resumeFile.getUserName() + "_" + fileName + "[" + resumeFile.getTags() + "]";
        String fileType = FileUtils.getFileSuffix(multipartFile);
        Long fileSize = multipartFile.getSize();

        try {
            File file = new File(filePath);
            if (!file.exists()) {
                if (!file.mkdir()) {
                    throw new BusinessException(500, "目录创建失败");
                }
            }
            File saveFile = new File(filePath, newFileName);
            multipartFile.transferTo(saveFile);
        } catch (Exception e) {
            e.printStackTrace();
            throw new BusinessException(500, "文件上传失败");
        }
        resumeFile.setFilePath(filePath);
        resumeFile.setFileName(newFileName);
        resumeFile.setFileType(fileType);
        resumeFile.setFileSize(fileSize);
        resumeFile.preInsert();
        baseMapper.insert(resumeFile);
    }

    @Override
    public void exportResumeFile(String resumeId, HttpServletRequest request, HttpServletResponse response) throws IOException {
        ResumeFile resumeFile = baseMapper.selectById(resumeId);
        File file = new File(resumeFile.getFilePath(), resumeFile.getFileName());
        String fileName = resumeFile.getFileName() + resumeFile.getFileType();
        response.reset();
        response.setCharacterEncoding("UTF-8");
        response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
        response.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + URLEncoder.encode(fileName, "UTF-8"));
        response.setHeader(HttpHeaders.ACCESS_CONTROL_EXPOSE_HEADERS, HttpHeaders.CONTENT_DISPOSITION);

        InputStream in = new FileInputStream(file);
        ServletOutputStream outputStream = response.getOutputStream();
        IOUtils.copy(in, outputStream);
        // 关闭输出流 否则下载文件会提示网络问题无法下载
        outputStream.flush();
        outputStream.close();
    }
}
