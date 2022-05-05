package com.hz.controller;

import com.hz.pojo.System;
import com.hz.service.SystemService;
import com.hz.utils.JsonMassage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author suolong
 * @Date 2022/5/4 14:46
 * @Version 1.5
 */
@Controller
@RequestMapping("/system")
public class SystemController {
    @Autowired
    private SystemService systemService;

    /**
     * 分页查询
     * @param page  当前页
     * @param limit 每页显示条数
     * @return
     */
    @RequestMapping(value = "/findSystemList",method = RequestMethod.GET)
    @ResponseBody
    public JsonMassage<List<System>> findSystemList(@RequestParam(value = "page",defaultValue = "1") Integer page,
                                                    @RequestParam(value = "limit",defaultValue ="10") Integer limit,
                                                    String systemId, String systemName){
        List<System> list = systemService.findSystemList(page,limit,systemId,systemName);
        Integer count = systemService.SystemCount(systemId,systemName);
        JsonMassage<List<System>> jsonMassage = new JsonMassage<List<System>>();
        jsonMassage.setCode(0);
        jsonMassage.setMsg("请求成功");
        jsonMassage.setData(list);
        jsonMassage.setCount(count);
        return jsonMassage;

    }
    @RequestMapping("/findAdminById/{adminId}")
    public String findAdminById(@PathVariable("systemId") Integer systemId, Model model){
        model.addAttribute("sy",systemService.findSystemById(systemId));
        return  "system/system_edit";
    }
    /**
     * 新增权限
     * @param system
     * @return
     */
    @RequestMapping(value = "/saveSystem",method = RequestMethod.POST)
    @ResponseBody
    public JsonMassage saveSystem(System system){
        Integer i = systemService.saveSystem(system);
        return new JsonMassage(i);
    }

    /**
     * 删除权限
     * @param systemId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/deleteSystemById",method = RequestMethod.POST)
    public JsonMassage deleteSystemById(Integer systemId){
        Integer i = systemService.deleteSystemById(systemId);
        return new JsonMassage(i);
    }

}
