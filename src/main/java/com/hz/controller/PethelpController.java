package com.hz.controller;


import com.hz.pojo.Pethelp;
import com.hz.service.PethelpService;
import com.hz.utils.JsonMassage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author suolong
 * @Date 2022/5/3 21:18
 * @Version 1.5
 */
@Controller
@RequestMapping("/pethelp")
public class PethelpController {
    @Autowired
    private PethelpService pethelpService;

    /**
     * 分页查询
     * @param page
     * @param limit
     * @param pethelpName
     * @param pethelpUserPhone
     * @return
     */
    @RequestMapping(value = "/findPethelpList",method = RequestMethod.GET)
    @ResponseBody
    public JsonMassage<List<Pethelp>> findPethelpList(@RequestParam(value = "page",defaultValue = "1") Integer page,
                                                    @RequestParam(value = "limit",defaultValue ="10") Integer limit,
                                                    String pethelpName, String pethelpUserPhone){
        List<Pethelp> list = pethelpService.findPethelpList(page,limit,pethelpName,pethelpUserPhone);
        Integer count = pethelpService.PethelpCount(pethelpName,pethelpUserPhone);
        JsonMassage<List<Pethelp>> jsonMassage = new JsonMassage<List<Pethelp>>();
        jsonMassage.setCode(0);
        jsonMassage.setMsg("请求成功");
        jsonMassage.setData(list);
        jsonMassage.setCount(count);
        return jsonMassage;
    }
    @RequestMapping(value = "/findPethelpById/{pethelpId}")
    public String findPethelpById(@PathVariable("pethelpId") Integer pethelpId, Model model){
        model.addAttribute("ph",pethelpService.findPethelpById(pethelpId));
        return "pethelp/pethelp_edit";

    }

    /**
     * 新增救助队
     * @param pethelp
     * @return
     */
    @RequestMapping(value = "/savePethelp",method = RequestMethod.POST)
    @ResponseBody
    public JsonMassage savePethelp(Pethelp pethelp){
        Integer i = pethelpService.savePethelp(pethelp);
        return new JsonMassage(i);

    }

    /**
     * 修改救助队
     * @param pethelp
     * @return
     */
    @RequestMapping(value = "/updatePethelp",method = RequestMethod.POST)
    @ResponseBody
    public JsonMassage updatePethelp(Pethelp pethelp){
        Integer i = pethelpService.updatePethelp(pethelp);
        return new JsonMassage(i);
    }
    /**
     * 删除救助队
     * @param pethelpId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/deletePethelpById",method = RequestMethod.POST)
    public JsonMassage deletePethelpById(Integer pethelpId){
        Integer i = pethelpService.deletePethelpById(pethelpId);
        return new JsonMassage(i);
    }
    /**
     * 根据ID查看救助队
     * @param pethelpId
     * @param model
     * @return
     */
    @RequestMapping("/seePethelpById/{pethelpId}")
    public String seePethelpById(@PathVariable("pethelpId") Integer pethelpId, Model model){
        model.addAttribute("ph",pethelpService.findPethelpById(pethelpId));
        return  "pethelp/pethelp_see";
    }

    /**
     * 查看救助队详情
     * @param pethelp
     * @return
     */
    @RequestMapping(value = "/seePethelp",method = RequestMethod.POST)
    @ResponseBody
    public String seePethelp(Pethelp pethelp){
        Integer i = pethelpService.seePethelp(pethelp);
        return "";
    }


}
