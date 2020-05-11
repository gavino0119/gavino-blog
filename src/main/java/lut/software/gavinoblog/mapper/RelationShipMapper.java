package lut.software.gavinoblog.mapper;

import lut.software.gavinoblog.pojo.RelationShip;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author ywg
 * @version 1.0
 * @description  文章和项目关联表
 * @date 2020/4/15 11:10
 */
@Mapper
public interface RelationShipMapper {

    /**
     * 根据meta编号获取关联
     * @param mid
     * @return
     */
    List<RelationShip> getRelationShipByMid(Integer mid);

    /**
     * 根据meta编号删除关联
     * @param mid
     */
    void deleteRelationShipByMid(Integer mid);

    /**
     * 获取数量
     * @param cid
     * @param mid
     * @return
     */
    Long getCountById(@Param("cid") Integer cid, @Param("mid") Integer mid);

    /**
     * 添加
     * @param relationShip
     * @return
     */
    int addRelationShip(RelationShip relationShip);

    /**
     * 根据文章编号删除关联
     * @param cid
     */
    void deleteRelationShipByCid(int cid);

    /**
     * 根据文章ID获取关联
     * @param cid
     */
    List<RelationShip> getRelationShipByCid(Integer cid);
}
