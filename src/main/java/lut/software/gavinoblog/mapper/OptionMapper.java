package lut.software.gavinoblog.mapper;

import lut.software.gavinoblog.pojo.Options;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author ywg
 * @version 1.0
 * @description 网站选项相关Dao接口
 * @date 2020/3/27 21:56
 */
@Mapper
public interface OptionMapper {
    /**
     * 获取网站全部信息
     * @return
     */
    List<Options> getOptions();

    /**
     * 更新网站配置
     * @param option
     */
    void updateOptionByName(Options option);

    /**
     * 通过名称网站配置
     * @param name
     * @return
     */
    Options getOptionByName(String name);
}
