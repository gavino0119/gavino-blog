package lut.software.gavinoblog.service.attach;

import com.github.pagehelper.PageInfo;
import lut.software.gavinoblog.dto.AttAchDto;
import lut.software.gavinoblog.pojo.AttAch;

/**
 * @author ywg
 * @version 1.0
 * @description 文件相关接口
 * @date 2020/4/3 16:23
 */
public interface AttAchService {
    /**
     * 添加单个附件信息
     * @param attAchDomain
     */
    void addAttAch(AttAch attAchDomain);

    /**
     * 获取所有的附件信息
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo<AttAchDto> getAtts(int pageNum, int pageSize);

    /**
     * 通过ID获取附件信息
     * @param id
     * @return
     */
    AttAchDto getAttAchById(Integer id);

    /**
     * 通过ID删除附件信息
     * @param id
     */
    void deleteAttAch(Integer id);
}
