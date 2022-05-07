package com.hz.dao;

import com.hz.pojo.Comments;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommentsDao {

    /**
     * 查询评论
     * @param pyl 偏移量
     * @param pageSize 每页显示数量
     * @return
     */

    List<Comments> findCommentsList(@Param("pyl") Integer pyl,
                                    @Param("pageSize") Integer pageSize,
                                    @Param("commentsText") String commentsText,
                                    @Param("commentsTime") String commentsTime
    );


    /**
     * 总记录数
     * @return
     */
    Integer commentsCount(@Param("commentsText") String commentsText,
                          @Param("commentsTime") String commentsTime);

    /**
     * 新增评论
     * @param comments
     * @return
     */
    Integer saveComments(Comments comments);

    /**
     * 删除评论
     * @param commentsId
     * @return
     */
    Integer deleteCommentsById(Integer commentsId);
}
