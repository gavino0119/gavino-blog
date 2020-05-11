package lut.software.gavinoblog.dto.cond;

/**
 * @author ywg
 * @version 1.0
 * @description  Meta查询条件
 * @date 2020/4/3 23:59
 */
public class MetaCond {
    /**
     * 名称
     */
    private String name;

    /**
     * 类型
     */
    private String type;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
