package com.hz.controller;

import com.hz.pojo.Petcircle;
import com.hz.service.PetCircleService;
import com.hz.utils.JsonMassage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author suolong
 * @Date 2022/5/6 11:19
 * @Version 1.5
 */
@Controller
@RequestMapping("/petcircle")
public class PetcircleController {
    @Autowired
    private PetCircleService petCircleService;


    /**
     * 分页查询
     * @param page
     * @param limit
     * @param petcircleId
     * @param petcircleUserId
     * @return
     */
    @RequestMapping(value = "/findPetcircleList",method = RequestMethod.GET)
    @ResponseBody
    public JsonMassage<List<Petcircle>> findPetcircleList(@RequestParam(value = "page",defaultValue = "1") Integer page,
                                                        @RequestParam(value = "limit",defaultValue ="10") Integer limit,
                                                        String petcircleId, String petcircleUserId){
        List<Petcircle> list = petCircleService.findPetcircleList(page,limit,petcircleId,petcircleUserId);
        Integer count = petCircleService.PetcircleCount(petcircleId,petcircleUserId);
        JsonMassage<List<Petcircle>> jsonMassage = new JsonMassage<List<Petcircle>>();
        jsonMassage.setCode(0);
        jsonMassage.setMsg("请求成功");
        jsonMassage.setData(list);
        jsonMassage.setCount(count);
        return jsonMassage;
    }
    @RequestMapping(value = "/findPetcircleById/{petcircleId}")
    public String findPetcircleById(@PathVariable("petcircleId") Integer petcircleId, Model model){
        model.addAttribute("pc",petCircleService.findPetcircleById(petcircleId));
        return "petCircle/petcircle_edit";

    }
    /**
     * 新增文章
     * @param petcircle
     * @return
     */
    @RequestMapping(value = "/savePetcircle",method = RequestMethod.POST)
    @ResponseBody
    public JsonMassage savePetcircle(Petcircle petcircle){
        Integer i = petCircleService.savePetcircle(petcircle);
        return new JsonMassage(i);

    }
    /**
     * 删除文章
     * @param petcircleId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/deletePetcircleById",method = RequestMethod.POST)
    public JsonMassage deletePetcircleById(Integer petcircleId){
        Integer i = petCircleService.deletePetcircleById(petcircleId);
        return new JsonMassage(i);
    }
    /**
     * 根据ID查看救助队
     * @param petcircleId
     * @param model
     * @return
     */
    @RequestMapping("/seePetcircleById/{petcircleId}")
    public String seePetcircleById(@PathVariable("petcircleId") Integer petcircleId, Model model){
        model.addAttribute("pc",petCircleService.findPetcircleById(petcircleId));
        return  "petCircle/petcircle_see";
    }

    /**
     * 查看救助队详情
     * @param petcircle
     * @return
     */
    @RequestMapping(value = "/seePetcircle",method = RequestMethod.POST)
    @ResponseBody
    public String seePetcircle(Petcircle petcircle){
        Integer i = petCircleService.seePetcircle(petcircle);
        return "";
    }
}
