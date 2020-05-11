package lut.software.gavinoblog.dto;

import lut.software.gavinoblog.pojo.Meta;

/**
 * @author ywg
 * @version 1.0
 * @description  标签、分类列表
 * @date 2020/4/3 12:56
 */
public class MetaDto extends Meta {

    private int count;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
