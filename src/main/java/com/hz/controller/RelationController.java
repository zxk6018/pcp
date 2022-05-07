package com.hz.controller;


import com.hz.pojo.Relation;
import com.hz.service.RelationService;
import com.hz.utils.JsonMassage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/relation")
public class RelationController {
    @Autowired
    private RelationService relationService;


    /**
     * 修改
     * @param
     * @return
     */
    @RequestMapping(value = "/updateRelation",method = RequestMethod.POST)
    @ResponseBody
    public JsonMassage updateRelation(Relation relation){
        Integer i = relationService.updateRelation(  relation);
        return new JsonMassage( i );
    }

    //新增
    @RequestMapping(value = "/saveRelation",method =RequestMethod.POST)
    @ResponseBody
    public JsonMassage saveRelation(Relation relation){
        Integer i = relationService.saveRelation( relation );
        return new JsonMassage( i );
    }

    /**
     * 分页查询
     * @param page  当前页
     * @param limit 每页显示条数
     * @return
     */
    @RequestMapping(value = "/findRelationList",method = RequestMethod.GET)
    @ResponseBody
    public JsonMassage<List<Relation>>findProvideList(
            @RequestParam(value = "page",defaultValue = "1")Integer page,
            @RequestParam(value = "limit",defaultValue = "10") Integer limit,
            Integer relationAdoptId ,Integer relationUserId ){
        List<Relation> list = relationService.findRelationList( page,limit,relationAdoptId,relationUserId );
        Integer count = relationService.relationCount( relationAdoptId,relationUserId );
        JsonMassage<List<Relation>> jsonMassage = new JsonMassage<List<Relation>>(  );
        jsonMassage.setCode( 0 );
        jsonMassage.setMsg( "请求成功" );
        jsonMassage.setData( list );
        jsonMassage.setCount( count );
        return jsonMassage;
    }
    /**
     * 根据ID查找
     * @param relationId
     * @param model
     * @return
     */
    @RequestMapping("/findRelationById/{relationId}")
    public String findRelationById( @PathVariable("relationId")Integer relationId, Model model){
        model.addAttribute( "wd",relationService.findRelationById( relationId ) );
        return "relation/relation_edit";
    }
    /**
     * 根据ID查找
     * @param relationId
     * @param model
     * @return
     */
    @RequestMapping("/seeRelationById/{relationId}")
    public String seeRelationById(@PathVariable("relationId")Integer relationId,Model model){
        model.addAttribute( "wd",relationService.findRelationById( relationId ) );
        return "relation/relation_see";
    }
    /**
     * 删除联系信息
     * @param relationId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/deleteRelationById",method = RequestMethod.POST)
    public JsonMassage deleteRelationById(Integer relationId){
        Integer i = relationService.deleteRelationById( relationId );
        return new JsonMassage( i );
    }
    /**
     * 查看
     * @param relation
     * @return
     */
    @RequestMapping(value = "/seeRelation",method = RequestMethod.POST)
    @ResponseBody
    public String seeRelation(Relation relation){
        Integer i =relationService.seeRelation( relation );
        return "";
    }
}
