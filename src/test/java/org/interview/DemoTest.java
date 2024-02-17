package org.interview;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * @Author      : Hullson
 * @Date        : create in 2024-02-07
 * @Description : 测试类
 */
@SpringBootTest
public class DemoTest {
    @Test
    void doTest() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, -7);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String today = simpleDateFormat.format(calendar.getTime());
        System.out.println(today);
    }
}
