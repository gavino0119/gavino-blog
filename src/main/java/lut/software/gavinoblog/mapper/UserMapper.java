package lut.software.gavinoblog.mapper;

import lut.software.gavinoblog.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author ywg
 * @version 1.0
 * @date 2020/3/5 15:51
 */
@Mapper
@Repository
public interface UserMapper {
    /**
     * 根据用户名密码获取用户信息
     * @param username  用户名
     * @param password  密码
     * @return
     */
    User getUserInfoByCond(@Param("username") String username, @Param("password") String password);
}
