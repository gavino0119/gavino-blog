package lut.software.gavinoblog.common.utils;

import lut.software.gavinoblog.common.constant.WebConst;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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


    private static Logger LOGGER = LoggerFactory.getLogger(Commons.class);
    /**
     * 获取随机数数
     *
     * @param max
     * @param str
     * @return
     */
    public static String random(int max, String str) {
        return UUID.random(1, max) + str;
    }

    public static String random(Long seed, int max, String str) {
        if (seed == null) {
            return random(max, str);
        }
        Random random = new Random(seed);
        return random.nextInt(max) + str;
    }

    /**
     * 返回gitHub头像地址
     *
     * @param email 邮箱
     * @return 头像链接地址
     */
    public static String gravatar(String email) {
        String avatarUrl = "https://github.com/identicons/";
        if (StringUtils.isBlank(email)) {
            email = "gavino0119@163.com";
        }
        LOGGER.info("当前email----> "+email);
        String hash = TaleUtils.MD5encode(email.trim().toLowerCase());
        return avatarUrl + hash + ".png";
    }

    /**
     * 网站链接
     *
     * @return
     */
    public static String site_url() {
        return site_url("");
    }

    /**
     * 返回网站链接下的全址
     *
     * @param sub 后面追加的地址
     * @return
     */
    public static String site_url(String sub) {
        return site_option("site_url") + sub;
    }

    /**
     * 网站配置项
     *
     * @param key
     * @return
     */
    public static String site_option(String key) {
        return site_option(key, "");
    }

    /**
     * 网站配置项
     *
     * @param key          键名
     * @param defaultValue 默认值
     * @return
     */
    public static String site_option(String key, String defaultValue) {
        if (StringUtils.isBlank(key)) {
            return "";
        }
        String str = WebConst.initConfig.get(key);
        if (StringUtils.isNotBlank(str)) {
            return str;
        } else {
            return defaultValue;
        }
    }
}