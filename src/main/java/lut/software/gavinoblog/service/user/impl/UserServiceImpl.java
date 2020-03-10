package lut.software.gavinoblog.service.user.impl;

import lut.software.gavinoblog.common.constant.ErrorConstant;
import lut.software.gavinoblog.common.exception.BusinessException;
import lut.software.gavinoblog.common.utils.TaleUtils;
import lut.software.gavinoblog.mapper.UserMapper;
import lut.software.gavinoblog.pojo.User;
import lut.software.gavinoblog.service.user.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ywg
 * @version 1.0
 * @description
 * @date 2020/3/5 16:03
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User login(String username, String password) {
        if (StringUtils.isBlank(username) || StringUtils.isBlank(password))
            throw BusinessException.withErrorCode(ErrorConstant.Auth.USERNAME_PASSWORD_IS_EMPTY);

        String pwd = TaleUtils.MD5encode(username + password);
        User user = userMapper.getUserInfoByCond(username,pwd);
        if (null == user)
            throw BusinessException.withErrorCode(ErrorConstant.Auth.USERNAME_PASSWORD_ERROR);
        return user;
    }

    @Override
    public User getUserInfoById(Integer uid) {
        return userMapper.getUserInfoById(uid);
    }
}
