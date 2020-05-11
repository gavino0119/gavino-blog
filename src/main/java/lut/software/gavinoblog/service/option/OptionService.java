package lut.software.gavinoblog.service.option;

import lut.software.gavinoblog.pojo.Options;

import java.util.List;
import java.util.Map;

/**
 * @author ywg
 * @version 1.0
 * @description 网站选项相关Service接口
 * @date 2020/3/27 21:55
 */
public interface OptionService {

    /**
     * 获取全部网站配置
     * @return
     */
    List<Options> getOptions();

    /**
     * 保存系统设置
     * @param querys
     */
    void saveOptions(Map<String,String> querys);

    /**
     * 更新网站配置
     * @param name
     * @param value
     */
    void updateOptionByName(String name, String value);

    /**
     * 通过名称获取网站配置
     * @param site_record
     * @return
     */
    Options getOptionByName(String site_record);
}

