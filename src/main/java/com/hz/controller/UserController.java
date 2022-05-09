package com.hz.controller;


import com.hz.pojo.User;
import com.hz.service.UserService;
import com.hz.utils.JsonMassage;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
     * 新增用户
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
     * 修改用户
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
    /**
     * 根据ID查询用户
     * @param userId
     * @param model
     * @return
     */
    @RequestMapping("/seeUserById/{userId}")
    public String seeAdminById(@PathVariable("userId") Integer userId, Model model){
        model.addAttribute("user",userService.findUserById(userId));
        return  "user/user_see";
    }

    /**
     * 查看用户详情
     * @param user
     * @return
     */
    @RequestMapping(value = "/seeUser",method = RequestMethod.POST)
    @ResponseBody
    public String seeAdmin(User user){
        Integer i = userService.seeUser(user);
        return "";
    }
    @RequestMapping(value = "/loginUser",method = RequestMethod.POST)
    @ResponseBody
    public JsonMassage<User> loginUser(@Param("userName") String userName,@Param("userPassword") String userPassword){
        System.out.println("userName===="+userName);
        System.out.println("userPassword===="+userPassword);
        User user = userService.loginUser(userName, userPassword);
        JsonMassage<User> jsonMassage = new JsonMassage<User>();
        if (user!=null){
             jsonMassage = new JsonMassage<User>(0,"登录成功",null,user);

        } else {
            jsonMassage = new JsonMassage<User>(1,"登录失败",null,null);
        }

        return jsonMassage;
    }


}
