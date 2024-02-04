package org.interview.common;

import lombok.Data;

/**
 * @Author      : Hullson
 * @Date        : created in 2024-02-04
 * @Description : 自定义业务异常类
 */

@Data
public class BusinessException extends RuntimeException {

    private Integer code = 0;

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(Integer code, String message) {
        super(message);
        this.code = code;
    }
}
