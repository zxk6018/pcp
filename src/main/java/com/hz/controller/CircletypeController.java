package com.hz.controller;


import com.hz.pojo.Circletype;
import com.hz.service.CircletypeService;
import com.hz.utils.JsonMassage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/circletype")
public class CircletypeController {
    @Autowired
    private CircletypeService circletypeService;
    /**
     * 分页查询
     * @param page  当前页
     * @param limit 每页显示条数
     * @return
     */
    @RequestMapping(value = "/findCircleTypeList",method = RequestMethod.GET)
    @ResponseBody
    public JsonMassage<List<Circletype>> findCircleTypeList(@RequestParam(value = "page",defaultValue = "1") Integer page,
                                                     @RequestParam(value = "limit",defaultValue ="10") Integer limit,
                                                     String circletypeName, String circletypeTime){
        List<Circletype> list = circletypeService.findCircletypetList(page,limit,circletypeName,circletypeTime);
        Integer count = circletypeService.circleTypeCount(circletypeName,circletypeTime);
        JsonMassage<List<Circletype>> jsonMassage = new JsonMassage<List<Circletype>>();
        jsonMassage.setCode(0);
        jsonMassage.setMsg("请求成功");
        jsonMassage.setCount(count);
        jsonMassage.setData(list);
        System.out.println(jsonMassage.toString());
        return jsonMassage;
    }

    //新增
    @RequestMapping(value = "/saveCircletype",method = RequestMethod.POST)
    @ResponseBody
    public JsonMassage saveCircletype(Circletype circletype){
        Integer i = circletypeService.saveCircletype(circletype);
        return new JsonMassage(i);
    }

    @RequestMapping("/findCircletypeById/{circletypeId}")
    public String findCircletypeById(@PathVariable("circletypeId") Integer circletypeId, Model model){
        model.addAttribute("circletype",circletypeService.findCircletypeById(circletypeId));
        return  "circleType/circleType_edit";
    }

    /**
     * 删除文章类型
     * @param circletypeId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/deleteCircletypeById",method = RequestMethod.POST)
    public JsonMassage deleteCircletypeById(Integer circletypeId){
        Integer i = circletypeService.deleteCircletypeById(circletypeId);
        return new JsonMassage(i);
    }

    /**
     * 修改文章类型
     * @param circletype
     * @return
     */
    @RequestMapping(value = "/updateCircletype",method = RequestMethod.POST)
    @ResponseBody
    public JsonMassage updateCircletype(Circletype circletype){
        Integer i = circletypeService.updateCircletype(circletype);
        return new JsonMassage(i);
    }


    /**
     * 查看文章类型
     * @param circletypeId
     * @return
     */

    @RequestMapping("/seeCircletypeById/{circletypeId}")
    public String seeCircletypeById(@PathVariable("circletypeId") Integer circletypeId, Model model){
        model.addAttribute("ci",circletypeService.findCircletypeById(circletypeId));
        return  "circleType/circleType_see";
    }

    @RequestMapping(value = "/seeCircletype",method = RequestMethod.POST)
    @ResponseBody
    public String seeCircletype(Circletype circletype){
        Integer i = circletypeService.seeCircletype(circletype);
        return "";
    }

}
