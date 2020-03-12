package lut.software.gavinoblog.service.site.impl;

import com.github.pagehelper.PageHelper;
import lut.software.gavinoblog.common.constant.ErrorConstant;
import lut.software.gavinoblog.common.constant.Types;
import lut.software.gavinoblog.dto.StatisticsDto;
import lut.software.gavinoblog.dto.cond.CommentCond;
import lut.software.gavinoblog.dto.cond.ContentCond;
import lut.software.gavinoblog.mapper.CommentMapper;
import lut.software.gavinoblog.mapper.ContentMapper;
import lut.software.gavinoblog.pojo.Content;
import lut.software.gavinoblog.service.site.SiteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ywg
 * @version 1.0
 * @description
 * @date 2020/3/11 18:07
 */
@Service
public class SiteServiceImpl implements SiteService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SiteServiceImpl.class);

    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private ContentMapper contentMapper;



    @Override
    @Cacheable(value = "siteCache", key = "'comments_' + #p0")
    public List<ErrorConstant.Comment> getComments(int limit) {
        LOGGER.debug("Enter recentComments method: limit={}", limit);
        if (limit < 0 || limit > 10) {
            limit = 10;
        }
        PageHelper.startPage(1,limit);
        List<ErrorConstant.Comment> rs = commentMapper.getCommentsByCond(new CommentCond());
        LOGGER.debug("Exit recentComments method");
        return rs;
    }

    @Override
    @Cacheable(value = "siteCache", key = "'newArticles_' + #p0")
    public List<Content> getNewArticles(int limit) {
        LOGGER.debug("Enter recentArticles method:limit={}",limit);
        if (limit < 0 || limit > 10) {
            limit = 10;
        }
        PageHelper.startPage(1,limit);
        List<Content> rs = contentMapper.getArticleByCond(new ContentCond());
        LOGGER.debug("Exit recentArticles method");
        return rs;
    }

    @Override
    @Cacheable(value = "siteCache", key = "'statistics_'")
    public StatisticsDto getStatistics() {
        LOGGER.debug("Enter recentStatistics method");

        // 文章总数
        Long articles = contentMapper.getArticleCount();

        // 评论总数
        Long comments = commentMapper.getCommentCount();


        StatisticsDto rs = new StatisticsDto();
        rs.setArticles(articles);
        rs.setComments(comments);
        LOGGER.debug("Exit recentStatistics method");
        return rs;
    }
}

