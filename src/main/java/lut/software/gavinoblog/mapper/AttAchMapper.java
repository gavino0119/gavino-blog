package lut.software.gavinoblog.mapper;


import lut.software.gavinoblog.dto.AttAchDto;
import lut.software.gavinoblog.pojo.AttAch;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author ywg
 * @version 1.0
 * @description 文件相关Dao接口
 * @date 2020/4/3 16:25
 */

@Mapper
public interface AttAchMapper {

    /**
     * 添加单个附件文件
     *
     * @param attAchDomain
     */
    void addAttAch(AttAch attAchDomain);

    /**
     * 获取所有的附件信息
     *
     * @return
     */
    List<AttAchDto> getAtts();

    /**
     * 获取附件总数
     *
     * @return
     */
    Long getAttAchCount();

    /**
     * 通过ID获取附件信息
     *
     * @param id
     * @return
     */
    AttAchDto getAttAchById(@Param("id") Integer id);

    /**
     * 通过ID删除附件信息
     *
     * @param id
     */
    void deleteAttAch(@Param("id") Integer id);
}
