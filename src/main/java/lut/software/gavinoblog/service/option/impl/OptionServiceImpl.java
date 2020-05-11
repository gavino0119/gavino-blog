package lut.software.gavinoblog.service.option.impl;

import lut.software.gavinoblog.common.constant.ErrorConstant;
import lut.software.gavinoblog.common.exception.BusinessException;
import lut.software.gavinoblog.mapper.OptionMapper;
import lut.software.gavinoblog.pojo.Options;
import lut.software.gavinoblog.service.option.OptionService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @author ywg
 * @version 1.0
 * @description
 * @date 2020/3/27 21:55
 */
@Service
public class OptionServiceImpl implements OptionService {

    @Autowired
    private OptionMapper optionDao;

    @Override
    @Cacheable(value = "optionsCache", key = "'options_'")
    public List<Options> getOptions() {
        return optionDao.getOptions();
    }

    @Override
    @Transactional
    @CacheEvict(value = {"optionsCache", "optionCache"}, allEntries = true, beforeInvocation = true)
    public void saveOptions(Map<String, String> options) {
        if (null != options && !options.isEmpty()) {
            options.forEach(this::updateOptionByName);
        }
    }

    @Override
    @Transactional
    @CacheEvict(value = {"optionsCache", "optionCache"}, allEntries = true, beforeInvocation = true)
    public void updateOptionByName(String name, String value) {
        if (StringUtils.isBlank(name))
            throw BusinessException.withErrorCode(ErrorConstant.Common.PARAM_IS_EMPTY);
        Options option = new Options();
        option.setName(name);
        option.setValue(value);
        optionDao.updateOptionByName(option);
    }

    @Override
    @Cacheable(value = "optionCache", key = "'optionByname+' + #p0")
    public Options getOptionByName(String name) {
        if (StringUtils.isBlank(name))
            throw BusinessException.withErrorCode(ErrorConstant.Common.PARAM_IS_EMPTY);
        return optionDao.getOptionByName(name);
    }
}

