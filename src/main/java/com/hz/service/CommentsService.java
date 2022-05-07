package com.hz.service;

import com.hz.pojo.Comments;
import java.util.List;

public interface CommentsService {

    /**
     * 查询评论
     * @param pyl 偏移量
     * @param pageSize 每页显示数量
     * @return
     */

    List<Comments> findCommentsList(Integer pyl,
                                    Integer pageSize,
                                    String commentsText,
                                    String commentsTime

    );


    /**
     * 总记录数
     * @return
     */
    Integer commentsCount(String commentsText,String commentsTime);

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
