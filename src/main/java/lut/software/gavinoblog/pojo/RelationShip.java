package lut.software.gavinoblog.pojo;

/**
 * @author ywg
 * @version 1.0
 * @description  文章关联信息表
 * @date 2020/4/15 14:11
 */
public class RelationShip {

    /**
     * 文章主键
     */
    private Integer cid;

    /**
     * 项目编号
     */
    private Integer mid;

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }
}

