package com.hz.controller;

import com.hz.pojo.Adopt;
import com.hz.service.AdoptService;
import com.hz.utils.JsonMassage;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@RequestMapping("/adopt")
public class AdoptController {
    @Autowired
    private AdoptService adoptService;
    /**
     * 分页查询
     * @param page  当前页
     * @param limit 每页显示条数
     * @return
     */
    @RequestMapping(value = "/findAdoptList",method = RequestMethod.GET)
    @ResponseBody
    public JsonMassage<List<Adopt>> findAdoptList(@RequestParam(value = "page",defaultValue = "1") Integer page,
                                                  @RequestParam(value = "limit",defaultValue ="10") Integer limit,
                                                  String adoptType,
                                                  String adoptTime){
        List<Adopt> list = adoptService.findAdoptList(page,limit,adoptType,adoptTime);
        Integer count = adoptService.AdoptCount(adoptType,adoptTime);
        JsonMassage<List<Adopt>> jsonMassage = new JsonMassage<List<Adopt>>();
        jsonMassage.setCode(0);
        jsonMassage.setMsg("请求成功");
        jsonMassage.setCount(count);
        jsonMassage.setData(list);
        return jsonMassage;
    }

    //新增
    @RequestMapping(value = "/saveAdopt",method = RequestMethod.POST)
    @ResponseBody
    public JsonMassage saveAdopt(Adopt adopt){
        Integer i = adoptService.saveAdopt(adopt);
        return new JsonMassage(i);
    }


    /**
     * 修改用户
     * @param adopt
     * @return
     */
    @RequestMapping(value = "/updateAdopt",method = RequestMethod.POST)
    @ResponseBody
    public JsonMassage updateAdmin(Adopt adopt){
        Integer i = adoptService.updateAdopt(adopt);
        return new JsonMassage(i);

    }


    /**
     * 删除用户
     * @param adoptId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/deleteAdoptById",method = RequestMethod.POST)
    public JsonMassage deleteAdoptById(Integer adoptId){
        Integer i = adoptService.deleteAdoptById(adoptId);
        return new JsonMassage(i);
    }
    /**
     * 根据ID查询用户
     * @param adoptId
     * @param model
     * @return
     */

    @RequestMapping("/findAdoptById/{adoptId}")
    public String findAdoptById(@PathVariable("adoptId") Integer adoptId, Model model){
        model.addAttribute("adopt",adoptService.findAdoptById(adoptId));
        return  "adopt/adopt_edit";
    }


    @RequestMapping("/seeAdopt/{adoptId}")
    public String seeAdoptById(@PathVariable("adoptId") Integer adoptId, Model model){
        model.addAttribute("adopt",adoptService.findAdoptById(adoptId));
        return  "adopt/adopt_see";
    }
    @RequestMapping(value = "/seeAdopt",method = RequestMethod.POST)
    @ResponseBody
    public String seeAdopt(Adopt adopt){
        Integer i = adoptService.seeAdopt(adopt);
        return "";
    }
}
