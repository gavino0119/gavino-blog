package lut.software.gavinoblog.mapper;

import lut.software.gavinoblog.dto.cond.ContentCond;
import lut.software.gavinoblog.pojo.Content;
import lut.software.gavinoblog.pojo.RelationShip;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author ywg
 * @version 1.0
 * @description  文章相关Dao接口
 * @date 2020/3/11 18:20
 */
public interface ContentMapper {
    /**
     * 添加文章
     * @param contentDomain
     */
    void addArticle(Content contentDomain);

    /**
     * 根据编号获取文章
     * @param cid
     * @return
     */
    Content getArticleById(Integer cid);

    /**
     * 更新文章
     * @param contentDomain
     */
    void updateArticleById(Content contentDomain);

    /**
     * 根据条件获取文章列表
     * @param contentCond
     * @return
     */
    List<Content> getArticleByCond(ContentCond contentCond);

    /**
     * 删除文章
     * @param cid
     */
    void deleteArticleById(Integer cid);

    /**
     * 获取文章总数
     * @return
     */
    Long getArticleCount();

    /**
     * 通过分类名获取文章
     * @param category
     * @return
     */
    List<Content> getArticleByCategory(@Param("category") String category);

    /**
     * 通过标签获取文章
     * @param cid
     * @return
     */
    List<Content> getArticleByTags(List<RelationShip> cid);
}

