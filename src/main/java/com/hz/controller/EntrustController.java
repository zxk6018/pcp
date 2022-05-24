package com.hz.controller;


import com.hz.pojo.Entrust;
import com.hz.service.EntrustService;
import com.hz.utils.JsonMassage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/entrust")
public class EntrustController {

    @Autowired
    public EntrustService entrustService;
    /**
     * 分页查询
     * @param page  当前页
     * @param limit 每页显示条数
     * @return
     */
    @RequestMapping(value = "/findEntrustList",method = RequestMethod.GET)
    @ResponseBody
    public JsonMassage<List<Entrust>> findEntrustList(@RequestParam(value = "page",defaultValue = "1") Integer page,
                                                      @RequestParam(value = "limit",defaultValue = "10") Integer limit,
                                                      String entrustAddress, String userName) {
        List<Entrust> list = entrustService.findEntrustList(page, limit, entrustAddress, userName);
        Integer count = entrustService.entrustCount(entrustAddress,userName);
        JsonMassage<List<Entrust>> jsonMassage = new JsonMassage<List<Entrust>>();
        jsonMassage.setCode(0);
        jsonMassage.setMsg("请求成功");
        jsonMassage.setCount(count);
        jsonMassage.setData(list);
        return jsonMassage;
    }

    /**
     * 删除角色
     * @param entrustId
     * @return
     */

    @RequestMapping(value = "/deleteEntrustById",method = RequestMethod.POST)
    @ResponseBody
    public JsonMassage deleteEntrustById(Integer entrustId){
        Integer i = entrustService.deleteEntrustById(entrustId);
        return new JsonMassage(i);
    }

    /**
     * 新增角色
     * @param entrust
     * @return
     */
    @RequestMapping(value = "/saveEntrust",method = RequestMethod.POST)
    @ResponseBody
    public JsonMassage saveEntrust(Entrust entrust){
        Integer i = entrustService.saveEntrust(entrust);
        return new JsonMassage(i);
    }


    /**
     * 修改角色
     * @param entrust
     * @return
     */

    @RequestMapping(value = "/updateEntrust",method = RequestMethod.POST)
    @ResponseBody
    public JsonMassage updateEntrust(Entrust entrust){
        Integer i = entrustService.updateEntrust(entrust);
        return new JsonMassage(i);
    }


    /**
     * 根据ID查询角色
     * @param entrustId
     * @param model
     * @return
     */

    @RequestMapping("/findEntrustById/{entrustId}")
    public String findEntrustById(@PathVariable("entrustId") Integer entrustId, Model model){
        model.addAttribute("ent",entrustService.findEntrustById(entrustId));
        return "entrust/entrust_edit";

    }

    @RequestMapping("/seeEntrustById/{entrustId}")
    public String seeEntrustById(@PathVariable("entrustId")Integer entrustId, Model model){
        model.addAttribute("ent",entrustService.findEntrustById(entrustId));
        return "entrust/entrust_see";

    }


    @RequestMapping(value = "seeEntrust",method = RequestMethod.POST)
    @ResponseBody
    public String seeEntrust(Entrust entrust){
        Integer i = entrustService.seeEntrust(entrust);
        return "";
    }



}

