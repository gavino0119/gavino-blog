package lut.software.gavinoblog.service.article;

import com.github.pagehelper.PageInfo;
import lut.software.gavinoblog.dto.cond.ContentCond;
import lut.software.gavinoblog.pojo.Content;
import lut.software.gavinoblog.pojo.Meta;

import java.util.List;

/**
 * @author ywg
 * @version 1.0
 * @description 文章相关Service接口
 * @date 2020/3/25 16:48
 */
public interface ContentService {

    /***
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
     * @param page
     * @param limit
     * @return
     */
    PageInfo<Content> getArticlesByCond(ContentCond contentCond, int page, int limit);

    /**
     * 删除文章
     * @param cid
     */
    void deleteArticleById(Integer cid);

    /**
     * 添加文章点击量
     * @param content
     */
    void updateContentByCid(Content content);

    /**
     * 通过分类获取文章
     * @param category
     * @return
     */
    List<Content> getArticleByCategory(String category);

    /**
     * 通过标签获取文章
     * @param tags
     * @return
     */
    List<Content> getArticleByTags(Meta tags);
}

