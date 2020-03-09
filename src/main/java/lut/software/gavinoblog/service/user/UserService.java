package lut.software.gavinoblog.service.user;

import lut.software.gavinoblog.pojo.User;

/**
 * @author ywg
 * @version 1.0
 * @description 用户相关Service接口
 * @date 2020/3/5 16:01
 */
public interface UserService {

    /**
     * 用户登录
     * @param username  用户名
     * @param password  密码
     * @return
     */
    User login(String username, String password);
}
