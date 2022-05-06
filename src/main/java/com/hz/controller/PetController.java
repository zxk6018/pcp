package com.hz.controller;

import com.hz.pojo.Pet;
import com.hz.service.PetService;
import com.hz.utils.JsonMassage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@RequestMapping("/pet")
public class PetController {
    @Autowired
    private PetService petService;
    /**
     * 分页查询
     * @param page  当前页
     * @param limit 每页显示条数
     * @return
     */
    @RequestMapping(value = "/findPetList",method = RequestMethod.GET)
    @ResponseBody
    public JsonMassage<List<Pet>> findPetList(@RequestParam(value = "page",defaultValue = "1") Integer page,
                                               @RequestParam(value = "limit",defaultValue ="10") Integer limit,
                                               String petName, String pettypeName){
        List<Pet> list = petService.findPetList(page, limit, petName,pettypeName);
        System.out.println(petName);
        Integer count = petService.PetCount(petName,pettypeName);
        JsonMassage<List<Pet>> jsonMassage = new JsonMassage<List<Pet>>();
        jsonMassage.setCode(0);
        jsonMassage.setMsg("请求成功");
        jsonMassage.setCount(count);
        jsonMassage.setData(list);
        return jsonMassage;
    }
     //新增
    @RequestMapping(value = "/savePet",method = RequestMethod.POST)
    @ResponseBody
    public JsonMassage savePet(Pet pet){
        Integer i = petService.savePet(pet);
        return new JsonMassage(i);
    }

    /**
     * 删除宠物
     * @param petId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/deletePetById",method = RequestMethod.POST)
    public JsonMassage deleteAdminById(Integer petId){
        Integer i = petService.deletePetById(petId);
        return new JsonMassage(i);
    }

    /**
     * 修改宠物
     * @param pet
     * @return
     */
    @RequestMapping(value = "/updatePet",method = RequestMethod.POST)
    @ResponseBody
    public JsonMassage updateAdmin(Pet pet){
        Integer i = petService.updatePet(pet);
        return new JsonMassage(i);
    }
    @RequestMapping("/findPetById/{PetId}")
    public String findAdminById(@PathVariable("PetId") Integer petId, Model model){
        model.addAttribute("pet",petService.findPetById(petId));
        return  "pet/pet_edit";
    }



    @RequestMapping("/seePetById/{PetId}")
    public String seeAdminById(@PathVariable("PetId") Integer petId, Model model){
        model.addAttribute("pet",petService.findPetById(petId));
        return  "pet/pet_see";
    }
    @RequestMapping(value = "/seePet",method = RequestMethod.POST)
    @ResponseBody
    public String seePet(Pet pet){
        Integer i = petService.seePet(pet);
        return "";
    }

}
