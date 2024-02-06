package org.interview.utils;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Author      : Hullson
 * @Date        : create in 2024-02-06
 * @Description : 文件处理工具类
 */

@Component
public class FileUtils {

    public static String getFileName(MultipartFile file) {
        String originalFilename = file.getOriginalFilename();
        int dotPosition = originalFilename.lastIndexOf(".");
        return originalFilename.substring(0, dotPosition);
    }

    public static String getFileSuffix(MultipartFile file) {
        String originalFilename = file.getOriginalFilename();
        int dotPosition = originalFilename.lastIndexOf(".");
        return originalFilename.substring(dotPosition);
    }
}
