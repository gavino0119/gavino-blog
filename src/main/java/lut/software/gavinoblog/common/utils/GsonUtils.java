package lut.software.gavinoblog.common.utils;

import com.google.gson.Gson;

/**
 * @author ywg
 * @version 1.0
 * @description json转换工具
 * @date 2020/3/10 14:21
 */
public class GsonUtils {
    private static final Gson gson = new Gson();

    public static String toJsonString(Object object) {
        return object == null ? null : gson.toJson(object);
    }
}
