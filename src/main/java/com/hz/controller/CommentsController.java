package com.hz.controller;

import com.hz.pojo.Comments;
import com.hz.service.CommentsService;
import com.hz.utils.JsonMassage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/comments")
public class CommentsController {

    @Autowired
    private CommentsService commentsService;

    /**
     * 分页查询
     * @param page  当前页
     * @param limit 每页显示条数
     * @return
     */
    @RequestMapping(value = "/findCommentsList",method = RequestMethod.GET)
    @ResponseBody
    public JsonMassage<List<Comments>> findCommentsList(@RequestParam(value = "page",defaultValue = "1") Integer page,
                                                       @RequestParam(value = "limit",defaultValue ="10") Integer limit,
                                                       String commentsText, String commentsTime){
        List<Comments> list = commentsService.findCommentsList(page,limit,commentsText,commentsTime);
        Integer count = commentsService.commentsCount(commentsText,commentsTime);
        JsonMassage<List<Comments>> jsonMassage = new JsonMassage<List<Comments>>();
        jsonMassage.setCode(0);
        jsonMassage.setMsg("请求成功");
        jsonMassage.setData(list);
        jsonMassage.setCount(count);
        return jsonMassage;

    }

    /**
     * 新增评论
     * @param comments
     * @return
     */
    @RequestMapping(value = "/saveComments",method = RequestMethod.POST)
    @ResponseBody
    public JsonMassage saveComments(Comments comments){
        Integer i = commentsService.saveComments(comments);
        return new JsonMassage(i);
    }
    /**
     * 删除评论
     * @param commentsId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/deleteCommentsById",method = RequestMethod.POST)
    public JsonMassage deleteCommentsById(Integer commentsId){
        Integer i = commentsService.deleteCommentsById(commentsId);
        return new JsonMassage(i);
    }
}
