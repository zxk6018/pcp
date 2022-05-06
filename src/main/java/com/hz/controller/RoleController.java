package com.hz.controller;


import com.hz.pojo.Role;
import com.hz.service.RoleService;
import com.hz.utils.JsonMassage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    public RoleService roleService;
    /**
     * 分页查询
     * @param page  当前页
     * @param limit 每页显示条数
     * @return
     */
    @RequestMapping(value = "findRoleList",method = RequestMethod.GET)
    @ResponseBody
    public JsonMassage<List<Role>> findRoleList(@RequestParam(value = "page",defaultValue = "1") Integer page,
                                                @RequestParam(value = "limit",defaultValue = "10") Integer limit,
                                                String roleName,String roleTime){
        List<Role> list = roleService.findRoleList(page, limit, roleName, roleTime);
        Integer count = roleService.roleCount(roleName, roleTime);
        JsonMassage<List<Role>> jsonMassage = new JsonMassage<List<Role>>();
        jsonMassage.setCode(0);
        jsonMassage.setMsg("请求成功");
        jsonMassage.setCount(count);
        jsonMassage.setData(list);
        return jsonMassage;
    }

    /**
     * 删除角色
     * @param roleId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/deleteRoleById",method = RequestMethod.POST)
    public JsonMassage deleteRoleById(Integer roleId){
        Integer i = roleService.deleteRoleById(roleId);
        return new JsonMassage(i);
    }


    /**
     * 新增角色
     * @param role
     * @return
     */
    @RequestMapping(value = "/saveRole",method = RequestMethod.POST)
    @ResponseBody
    public JsonMassage saveRole(Role role){
        Integer i = roleService.saveRole(role);
        return new JsonMassage(i);
    }
    /**
     * 修改角色
     * @param role
     * @return
     */
    @RequestMapping(value = "/updateRole",method = RequestMethod.POST)
    @ResponseBody
    public JsonMassage updateRole(Role role){
        Integer i = roleService.updateRole(role);
        return new JsonMassage(i);
    }


    /**
     * 根据ID查询角色
     * @param roleId
     * @param model
     * @return
     */

    @RequestMapping("/findRoleById/{roleId}")
    public String findRoleById(@PathVariable("roleId") Integer roleId, Model model) {
        model.addAttribute("role",roleService.findRoleById(roleId));
        return "role/role_edit";


        /**
         * 根据ID查询角色
         * @param roleId
         * @param model
         * @return
         */
    }
    @RequestMapping("/seeRoleById/{roleId}")
    public String seeRoleById(@PathVariable("roleId") Integer roleId, Model model) {
        model.addAttribute("role",roleService.findRoleById(roleId));
        return "role/role_see";
    }

    /**
     * 查看角色详情
     * @param role
     * @return
     */
    @RequestMapping(value = "/seeRole",method = RequestMethod.POST)
    @ResponseBody
    public String seeRole(Role role){
        Integer i = roleService.seeRole(role);
        return "";
    }


}
