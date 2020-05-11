package lut.software.gavinoblog.common.utils;

import lut.software.gavinoblog.pojo.Meta;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

/**
 * @author ywg
 * @version 1.0
 * @description 后台公共函数
 * @date 2020/3/24 23:26
 */
@Component
public final class AdminCommons {


    /**
     * 判断category和cat的交集
     *
     * @param category
     * @param cats
     * @return
     */
    public static boolean exist_cat(Meta category, String cats) {
        String[] arr = StringUtils.split(cats, ",");
        if (null != arr && arr.length > 0) {
            for (String c : arr) {
                if (c.trim().equals(category.getName())) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 定义颜色样式数组
     */
    private static final String[] COLORS = {"default", "primary", "success", "info", "warning", "danger", "inverse", "purple", "pink"};

    /**
     * 随机样式
     *
     * @return
     */
    public static String rand_color() {
        int r = Tools.rand(0, COLORS.length - 1);
        return COLORS[r];
    }

}

