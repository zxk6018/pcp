package com.hz.controller;


import com.hz.pojo.User;
import com.hz.service.UserService;
import com.hz.utils.JsonMassage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 分页查询
     * @param pageNo  当前页
     * @param limit 每页显示条数
     * @return
     */
    @RequestMapping(value = "/findUserList",method = RequestMethod.POST)
    @ResponseBody
    public JsonMassage<List<User>> findProvideList(@RequestParam(value = "pageNo",defaultValue = "1") Integer pageNo,
                                                   @RequestParam(value = "limit",defaultValue ="1") Integer limit,
                                                   String userName){
        List<User> list = userService.findUserList(pageNo, limit, userName);
        System.out.println(userName);
        Integer count = userService.UserCount(userName);
        JsonMassage<List<User>> jsonMassage = new JsonMassage<List<User>>();
        jsonMassage.setCode(200);
        jsonMassage.setMsg("ok");
        jsonMassage.setCount(count);
        jsonMassage.setData(list);
        System.out.println(jsonMassage.toString());
        return jsonMassage;
    }

    /**
     * 删除用户
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/deleteUserById",method = RequestMethod.POST)
    public JsonMassage deleteAdminById(Integer id){
        Integer i = userService.deleteUserById(id);
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
}
