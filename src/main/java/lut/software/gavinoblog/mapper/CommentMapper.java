package lut.software.gavinoblog.mapper;

import lut.software.gavinoblog.common.constant.ErrorConstant;
import lut.software.gavinoblog.dto.cond.CommentCond;

import java.util.List;

/**
 * @author ywg
 * @version 1.0
 * @description
 * @date 2020/3/11 18:10
 */
public interface CommentMapper {
    /**
     * 根据条件获取评论列表
     * @param commentCond
     * @return
     */
    List<ErrorConstant.Comment> getCommentsByCond(CommentCond commentCond);

    /**
     * 获取评论总数
     * @return
     */
    Long getCommentCount();
}
