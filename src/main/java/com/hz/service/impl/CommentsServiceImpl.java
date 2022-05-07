package com.hz.service.impl;

import com.hz.dao.CommentsDao;
import com.hz.pojo.Comments;
import com.hz.service.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentsServiceImpl implements CommentsService {

    @Autowired
    private CommentsDao commentsDao;

    /**
     * 多条件 分页查询
     * @param page
     * @param pageSize 每页显示数量
     * @param commentsTime
     * @param commentsText
     * @return
     */
    @Override
    public List<Comments> findCommentsList(Integer page, Integer pageSize, String commentsText,String commentsTime) {
        int pyl = (page-1)*pageSize;
        return commentsDao.findCommentsList(pyl, pageSize, commentsText, commentsTime);
    }

    /**
     * 总记录数
     * @param commentsTime
     * @param commentsText
     * @return
     */
    @Override
    public Integer commentsCount(String commentsText,String commentsTime) {
        return commentsDao.commentsCount(commentsText, commentsTime);
    }

    /**
     * 新增评论
     * @param comments
     * @return
     */
    @Override
    public Integer saveComments(Comments comments) {
        return commentsDao.saveComments(comments);
    }

    /**
     * 删除评论
     * @param commentsId
     * @return
     */
    @Override
    public Integer deleteCommentsById(Integer commentsId) {
        return commentsDao.deleteCommentsById(commentsId);
    }
}
