package com.hz.service;

import com.hz.pojo.Pet;


import java.util.List;

public interface PetService {
    /**
     * 查询宠物
     * @param pyl
     * @param pageSize
     * @return
     */
    List<Pet> findPetList(Integer pyl,
                          Integer pageSize,
                          String petName,
                          String pettypeName
    );
    /**
     * 总记录数
     * @return
     */
    Integer PetCount( String petName,String pettypeName);

    /**
     * 新增宠物
     * @param pet
     * @return
     */
    Integer savePet(Pet pet);

    /**
     * 删除宠物
     * @param petId
     * @return
     */
    Integer deletePetById(Integer petId);

    /**
     * 修改宠物
     * @param pet
     * @return
     */
    Integer updatePet(Pet pet);

    /**
     * 根据ID  获得宠物
     * @param petId
     * @return
     */
    Pet findPetById(Integer petId);


    /**
     * 查看宠物详情
     * @param pet
     * @return
     */
    Integer seePet(Pet pet);

}
