package lut.software.gavinoblog.service.attach.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lut.software.gavinoblog.common.constant.ErrorConstant;
import lut.software.gavinoblog.common.exception.BusinessException;
import lut.software.gavinoblog.dto.AttAchDto;
import lut.software.gavinoblog.mapper.AttAchMapper;
import lut.software.gavinoblog.pojo.AttAch;
import lut.software.gavinoblog.service.attach.AttAchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ywg
 * @version 1.0
 * @description 文件接口实现
 * @date 2020/4/3 16:24
 */
@Service
public class AttAchServiceImpl implements AttAchService {

    @Autowired
    private AttAchMapper attAchDao;

    @Override
    @CacheEvict(value = {"attCaches", "attCache"}, allEntries = true, beforeInvocation = true)
    public void addAttAch(AttAch attAchDomain) {
        if (null == attAchDomain)
            throw BusinessException.withErrorCode(ErrorConstant.Common.PARAM_IS_EMPTY);
        attAchDao.addAttAch(attAchDomain);
    }

    @Override
    @Cacheable(value = "attCaches", key = "'atts' + #p0")
    public PageInfo<AttAchDto> getAtts(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<AttAchDto> atts = attAchDao.getAtts();
        PageInfo<AttAchDto> pageInfo = new PageInfo<>(atts);
        return pageInfo;
    }

    @Override
    @Cacheable(value = "attCaches", key = "'attAchByid' + #p0")
    public AttAchDto getAttAchById(Integer id) {
        if (null == id)
            throw BusinessException.withErrorCode(ErrorConstant.Common.PARAM_IS_EMPTY);
        return attAchDao.getAttAchById(id);
    }

    @Override
    @CacheEvict(value = {"attCaches", "attCache"}, allEntries = true, beforeInvocation = true)
    public void deleteAttAch(Integer id) {
        if (null == id)
            throw BusinessException.withErrorCode(ErrorConstant.Common.PARAM_IS_EMPTY);
        attAchDao.deleteAttAch(id);
    }
}

