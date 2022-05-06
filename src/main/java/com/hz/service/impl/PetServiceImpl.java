package com.hz.service.impl;


import com.hz.dao.PetDao;
import com.hz.pojo.Pet;
import com.hz.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PetServiceImpl implements PetService {

    @Autowired
    private PetDao petDao;

    /**
     * 多条件  分页查询
     * @param page
     * @param pageSize
     * @param petName
     * @param pettypeName
     * @return
     */
    @Override
    public List<Pet> findPetList(Integer page, Integer pageSize, String petName, String pettypeName) {
        Integer pyl = (page-1)*pageSize;
        return petDao.findPetList(pyl,pageSize,petName,pettypeName);
    }

    /**
     * 总记录数
     * @param petName
     * @param pettypeName
     * @return
     */
    @Override
    public Integer PetCount(String petName, String pettypeName) {
        return petDao.PetCount(petName,pettypeName);
    }

    /**
     * 新增宠物
     * @param pet
     * @return
     */
    @Override
    public Integer savePet(Pet pet) {
        return petDao.savePet(pet);
    }

    /**
     * 删除宠物
     * @param petId
     * @return
     */
    @Override
    public Integer deletePetById(Integer petId) {
        return petDao.deletePetById(petId);
    }

    /**
     * 修改宠物
     * @param pet
     * @return
     */
    @Override
    public Integer updatePet(Pet pet) {
        return petDao.updatePet(pet);
    }

    /**
     * 根据ID 查询宠物
     * @param petId
     * @return
     */
    @Override
    public Pet findPetById(Integer petId) {
        return petDao.findPetById(petId);
    }

    /**
     * 查看宠物详情
     * @param pet
     * @return
     */
    @Override
    public Integer seePet(Pet pet) {
        return petDao.seePet(pet);
    }
}
