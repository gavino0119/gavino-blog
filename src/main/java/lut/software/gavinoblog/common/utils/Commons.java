package lut.software.gavinoblog.common.utils;

import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * @author ywg
 * @version 1.0
 * @description 公共函数
 * @date 2020/3/10 10:05
 */
@Component
public class Commons {


    /**
     * 获取随机数数
     * @param max
     * @param str
     * @return
     */
    public static String random(int max, String str) {
        return UUID.random(1,max) + str;
    }

    public static String random(Long seed, int max, String str) {
        if (seed == null) {
            return random(max, str);
        }
        Random random = new Random(seed);
        return random.nextInt(max) +str;
    }

}
