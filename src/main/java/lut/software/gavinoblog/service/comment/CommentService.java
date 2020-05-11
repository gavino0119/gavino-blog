package lut.software.gavinoblog.service.comment;

import com.github.pagehelper.PageInfo;
import lut.software.gavinoblog.dto.cond.CommentCond;
import lut.software.gavinoblog.pojo.Comment;

import java.util.List;

/**
 * @author ywg
 * @version 1.0
 * @description 评论相关Service接口
 * @date 2020/3/31 15:40
 */
public interface CommentService {
    /**
     * 添加评论
     * @param comments
     */
    void addComment(Comment comments);

    /**
     * 通过文章ID获取评论
     * @param cid
     * @return
     */
    List<Comment> getCommentsByCId(Integer cid);

    /**
     * 根据条件获取评论列表
     * @param commentCond   查询条件
     * @param pageNum       分页参数 第几页
     * @param pageSize      分页参数 每页条数
     * @return
     */
    PageInfo<Comment> getCommentsByCond(CommentCond commentCond, int pageNum, int pageSize);

    /**
     * 通过ID获取评论
     * @param coid
     * @return
     */
    Comment getCommentById(Integer coid);

    /**
     * 更新评论状态
     * @param coid
     * @param status
     */
    void updateCommentStatus(Integer coid, String status);

    /**
     * 删除评论
     * @param id
     */
    void deleteComment(Integer id);

}

