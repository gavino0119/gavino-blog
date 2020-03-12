package lut.software.gavinoblog.mapper;

import lut.software.gavinoblog.dto.cond.ContentCond;
import lut.software.gavinoblog.pojo.Content;

import java.util.List;

/**
 * @author ywg
 * @version 1.0
 * @description
 * @date 2020/3/11 18:20
 */
public interface ContentMapper {
    /**
     * 根据条件获取文章列表
     * @param contentCond
     * @return
     */
    List<Content> getArticleByCond(ContentCond contentCond);

    /**
     * 获取文章总数
     * @return
     */
    Long getArticleCount();
}
