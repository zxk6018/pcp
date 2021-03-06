package com.hz.controller;

import com.hz.pojo.Admin;
import com.hz.service.AdminService;
import com.hz.utils.JsonMassage;
import com.hz.utils.MD5untils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    /**
     * 管理员登录
     * @param username
     * @param password
     * @return
     */
    @RequestMapping(value = "/doLogin",method = RequestMethod.POST)
    @ResponseBody
    public JsonMassage<Admin> doLogin(String username,String password){
        System.out.println("username==="+username);
        System.out.println("password==="+password);
        MD5untils md5untils = new MD5untils();
        String newpassword = md5untils.md5(password);
        System.out.println("加密后的密码："+newpassword);
        Admin admin = adminService.doLogin(username, newpassword);
        JsonMassage<Admin> jsonMassage = new JsonMassage<Admin>();
        if (admin!=null){
            jsonMassage = new JsonMassage<Admin>(0,"登录成功",null,admin);
        } else {
            jsonMassage = new JsonMassage<Admin>(1,"账号或密码错误",null,null);
        }
        return jsonMassage;
    }

    /**
     * 删除管理员
     * @param adminId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/deleteAdminById",method = RequestMethod.POST)
    public JsonMassage deleteAdminById(Integer adminId){
        Integer i = adminService.deleteAdminById(adminId);
        return new JsonMassage(i);
    }

    /**
     * 修改管理员
     * @param admin
     * @return
     */
    @RequestMapping(value = "/updateAdmin",method = RequestMethod.POST)
    @ResponseBody
    public JsonMassage updateAdmin(Admin admin){
        Integer i = adminService.updateAdmin(admin);
        return new JsonMassage(i);
    }

    /**
     * 新增管理员
     * @param admin
     * @return
     */
    @RequestMapping(value = "/saveAdmin",method = RequestMethod.POST)
    @ResponseBody
    public JsonMassage saveProvider(Admin admin){
        Integer i = adminService.saveAdmin(admin);
        return new JsonMassage(i);
    }

    /**
     * 分页查询
     * @param page  当前页
     * @param limit 每页显示条数
     * @return
     */
    @RequestMapping(value = "/findAdminList",method = RequestMethod.GET)
    @ResponseBody
    public JsonMassage<List<Admin>> findProvideList(@RequestParam(value = "page",defaultValue = "1") Integer page,
                                                    @RequestParam(value = "limit",defaultValue ="10") Integer limit,
                                                    String adminName,
                                                    String adminPhone){
        List<Admin> list = adminService.findAdminList(page,limit,adminName,adminPhone);
        Integer count = adminService.AdminCount(adminName,adminPhone);
        JsonMassage<List<Admin>> jsonMassage = new JsonMassage<List<Admin>>();
        jsonMassage.setCode(0);
        jsonMassage.setMsg("请求成功");
        jsonMassage.setData(list);
        jsonMassage.setCount(count);
        return jsonMassage;

    }
    /**
     * 根据ID查找管理员
     * @param adminId
     * @param model
     * @return
     */
    @RequestMapping("/findAdminById/{adminId}")
    public String findAdminById(@PathVariable("adminId") Integer adminId, Model model){
        model.addAttribute("ad",adminService.findAdminById(adminId));
        return  "admin/admin_edit";
    }

    /**
     * 根据ID查找管理员
     * @param adminId
     * @param model
     * @return
     */
    @RequestMapping("/seeAdminById/{adminId}")
    public String seeAdminById(@PathVariable("adminId") Integer adminId, Model model){
        model.addAttribute("ad",adminService.findAdminById(adminId));
        return  "admin/admin_see";
    }

    /**
     * 查看管理员
     * @param admin
     * @return
     */
    @RequestMapping(value = "/seeAdmin",method = RequestMethod.POST)
    @ResponseBody
    public String seeAdmin(Admin admin){
        Integer i = adminService.seeAdmin(admin);
        return "";
    }
}
