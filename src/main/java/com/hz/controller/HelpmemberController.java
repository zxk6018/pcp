package com.hz.controller;

import com.hz.pojo.Helpmember;
import com.hz.service.HelpmemberService;
import com.hz.utils.JsonMassage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author suolong
 * @Date 2022/5/5 17:41
 * @Version 1.5
 */
@Controller
@RequestMapping("/helpmember")
public class HelpmemberController {

    @Autowired
    private HelpmemberService helpmemberService;

    /**
     * 分页查询
     *
     * @param page
     * @param limit
     * @param helpmemberId
     * @param helpmemberPethelpId
     * @return
     */
    @RequestMapping(value = "/findHelpmemberList", method = RequestMethod.GET)
    @ResponseBody
    public JsonMassage<List<Helpmember>> findHelpmemberList(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                                            @RequestParam(value = "limit", defaultValue = "10") Integer limit,
                                                            String helpmemberId, String helpmemberPethelpId) {
        List<Helpmember> list = helpmemberService.findHelpmemberList(page, limit, helpmemberId, helpmemberPethelpId);
        Integer count = helpmemberService.HelpmemberCount(helpmemberId, helpmemberPethelpId);
        JsonMassage<List<Helpmember>> jsonMassage = new JsonMassage<List<Helpmember>>();
        jsonMassage.setCode(0);
        jsonMassage.setMsg("请求成功");
        jsonMassage.setData(list);
        jsonMassage.setCount(count);
        return jsonMassage;
    }

    @RequestMapping(value = "/findHelpmemberById/{helpmemberId}")
    public String findHelpmemberById(@PathVariable("helpmemberId") Integer helpmemberId, Model model) {
        model.addAttribute("hm", helpmemberService.findHelpmemberById(helpmemberId));
        return "helpMember/helpmember_edit";

    }

    /**
     * 新增救助队队员
     *
     * @param helpmember
     * @return
     */
    @RequestMapping(value = "/saveHelpmember", method = RequestMethod.POST)
    @ResponseBody
    public JsonMassage saveHelpmember(Helpmember helpmember) {
        Integer i = helpmemberService.saveHelpmember(helpmember);
        return new JsonMassage(i);

    }

    /**
     * 修改救助队队员
     *
     * @param helpmember
     * @return
     */
    @RequestMapping(value = "/updateHelpmember", method = RequestMethod.POST)
    @ResponseBody
    public JsonMassage updateHelpmember(Helpmember helpmember) {
        Integer i = helpmemberService.updateHelpmember(helpmember);
        return new JsonMassage(i);
    }

    /**
     * 删除救助队队员
     *
     * @param helpmemberId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/deletePethelpById", method = RequestMethod.POST)
    public JsonMassage deleteHelpmemberById(Integer helpmemberId) {
        Integer i = helpmemberService.deleteHelpmemberById(helpmemberId);
        return new JsonMassage(i);
    }

    /**
     * 根据ID查看救助队队员信息
     *
     * @param HelpmemberId
     * @param model
     * @return
     */
    @RequestMapping("/seeHelpmemberById/{HelpmemberId}")
    public String seeHelpmemberById(@PathVariable("HelpmemberId") Integer HelpmemberId, Model model) {
        model.addAttribute("hm", helpmemberService.findHelpmemberById(HelpmemberId));
        return "helpMember/helpmember_see";
    }

    /**
     * 查看救助队队员详细信息
     *
     * @param helpmember
     * @return
     */
    @RequestMapping(value = "/seeHelpmember", method = RequestMethod.POST)
    @ResponseBody
    public String seePethelp(Helpmember helpmember) {
        Integer i = helpmemberService.seeHelpmember(helpmember);
        return "";
    }
}
