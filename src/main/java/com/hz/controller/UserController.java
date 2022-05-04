package com.hz.controller;


import com.hz.pojo.User;
import com.hz.service.UserService;
import com.hz.utils.JsonMassage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 分页查询
     * @param page  当前页
     * @param limit 每页显示条数
     * @return
     */
    @RequestMapping(value = "/findUserList",method = RequestMethod.GET)
    @ResponseBody
    public JsonMassage<List<User>> findUserList(@RequestParam(value = "page",defaultValue = "1") Integer page,
                                                @RequestParam(value = "limit",defaultValue ="10") Integer limit,
                                                String userName,String userTime){
        List<User> list = userService.findUserList(page, limit, userName,userTime);
        System.out.println(userName);
        Integer count = userService.UserCount(userName,userTime);
        JsonMassage<List<User>> jsonMassage = new JsonMassage<List<User>>();
        jsonMassage.setCode(0);
        jsonMassage.setMsg("请求成功");
        jsonMassage.setCount(count);
        jsonMassage.setData(list);
        return jsonMassage;
    }

    /**
     * 删除用户
     * @param userId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/deleteUserById",method = RequestMethod.POST)
    public JsonMassage deleteAdminById(Integer userId){
        Integer i = userService.deleteUserById(userId);
        return new JsonMassage(i);
    }

    /**
     * 新增管理员
     * @param user
     * @return
     */
    @RequestMapping(value = "/saveUser",method = RequestMethod.POST)
    @ResponseBody
    public JsonMassage saveUser(User user){
        Integer i = userService.saveUser(user);
        return new JsonMassage(i);
    }
    /**
     * 修改管理员
     * @param user
     * @return
     */
    @RequestMapping(value = "/updateUser",method = RequestMethod.POST)
    @ResponseBody
    public JsonMassage updateAdmin(User user){
        Integer i = userService.updateUser(user);
        return new JsonMassage(i);
    }
    /**
     * 根据ID查询用户
     * @param userId
     * @param model
     * @return
     */
    @RequestMapping("/findUserById/{userId}")
    public String findAdminById(@PathVariable("userId") Integer userId, Model model){
        model.addAttribute("user",userService.findUserById(userId));
        return  "user/user_edit";
    }

    @RequestMapping("/seeUserById/{userId}")
    public String seeAdminById(@PathVariable("userId") Integer userId, Model model){
        model.addAttribute("user",userService.findUserById(userId));
        return  "user/user_see";
    }

    @RequestMapping(value = "/seeUser",method = RequestMethod.POST)
    @ResponseBody
    public String seeAdmin(User user){
        Integer i = userService.seeAdmin(user);
        return "";
    }
}
