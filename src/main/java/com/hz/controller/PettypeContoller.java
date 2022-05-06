package com.hz.controller;


import com.hz.pojo.Pettype;
import com.hz.service.PetTypeService;
import com.hz.utils.JsonMassage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author suolong
 * @Date 2022/5/5 14:07
 * @Version 1.5
 */
@Controller
@RequestMapping("/pettype")
public class PettypeContoller {

    @Autowired
    private PetTypeService petTypeService;


    /**
     * 分页查询
     * @param page
     * @param limit
     * @param pettypeId
     * @param pettypeName
     * @return
     */
    @RequestMapping(value = "/findPettypeList",method = RequestMethod.GET)
    @ResponseBody
    public JsonMassage<List<Pettype>> findPettypeList(@RequestParam(value = "page",defaultValue = "1") Integer page,
                                                      @RequestParam(value = "limit",defaultValue ="10") Integer limit,
                                                      String pettypeId, String pettypeName){
        List<Pettype> list = petTypeService.findPettypeList(page,limit,pettypeId,pettypeName);
        Integer count = petTypeService.PettypeCount(pettypeId,pettypeName);
        JsonMassage<List<Pettype>> jsonMassage = new JsonMassage<List<Pettype>>();
        jsonMassage.setCode(0);
        jsonMassage.setMsg("请求成功");
        jsonMassage.setData(list);
        jsonMassage.setCount(count);
        return jsonMassage;
    }
    @RequestMapping(value = "/findPettypeById/{pettypeId}")
    public String findPettypeById(@PathVariable("pettypeId") Integer pettypeId, Model model){
        model.addAttribute("ph",petTypeService.findPettypeById(pettypeId));
        return "pettype/pettype_edit";

    }
    /**
     * 新增宠物类型
     * @param pettype
     * @return
     */
    @RequestMapping(value = "/savePettype",method = RequestMethod.POST)
    @ResponseBody
    public JsonMassage savePettype(Pettype pettype){
        Integer i = petTypeService.savePettype(pettype);
        return new JsonMassage(i);

    }
    /**
     * 删除宠物类型
     * @param pettypeId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/deletePettypeById",method = RequestMethod.POST)
    public JsonMassage deletePettypeById(Integer pettypeId){
        Integer i = petTypeService.deletePettypeById(pettypeId);
        return new JsonMassage(i);
    }

}
