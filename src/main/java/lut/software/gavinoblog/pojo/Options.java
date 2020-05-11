package lut.software.gavinoblog.pojo;

import java.io.Serializable;

/**
 * @author ywg
 * @version 1.0
 * @description 网站配置项
 * @date 2020/3/13 13:58
 */
public class Options implements Serializable {
    /**
     * 名称
     */
    private String name;
    /**
     * 内容
     */
    private String value;

    /**
     * 描述
     */
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}