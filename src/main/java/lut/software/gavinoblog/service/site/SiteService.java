package lut.software.gavinoblog.service.site;

import lut.software.gavinoblog.common.constant.ErrorConstant;
import lut.software.gavinoblog.dto.StatisticsDto;
import lut.software.gavinoblog.pojo.Content;

import java.util.List;

/**
 * @author ywg
 * @version 1.0
 * @description 网站相关接口
 * @date 2020/3/10 14:28
 */
public interface SiteService {

    /**
     * 获取评论列表
     * @param limit
     * @return
     */
    List<ErrorConstant.Comment> getComments(int limit);

    /**
     * 获取文章列表
     * @param limit
     * @return
     */
    List<Content> getNewArticles(int limit);

    /**
     * 获取后台统计数
     * @return
     */
    StatisticsDto getStatistics();
}

