package lut.software.gavinoblog.dto;

/**
 * @author ywg
 * @version 1.0
 * @description  公共属性的类
 * @date 2020/4/3 16:30
 */
public class BaseDto {
    /**
     * 用户名
     */
    private String userName;

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }
}
