package org.interview.utils;

import java.util.UUID;

/**
 * @Author      : Hullson
 * @Date        : create in 2024-02-01
 * @Description : 描述
 */
public class GenerateID {

    public static String generateUUID() {
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        return uuid;
    }
}
