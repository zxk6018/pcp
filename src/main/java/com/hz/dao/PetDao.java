package com.hz.dao;

import com.hz.pojo.Pet;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PetDao {
    /**
     * 查询宠物
     * @param pyl
     * @param pageSize
     * @return
     */
    List<Pet> findPetList(@Param("pyl") Integer pyl,
                            @Param("pageSize") Integer pageSize,
                            @Param("petName") String petName,
                            @Param("pettypeName") String pettypeName
    );
    /**
     * 总记录数
     * @return
     */
    Integer PetCount(@Param("petName") String petName,
                      @Param("pettypeName") String pettypeName);

    /**
     * 新增
     * @param pet
     * @return
     */
    Integer savePet(Pet pet);

    /**
     * 删除
     * @param petId
     * @return
     */
    Integer deletePetById(Integer petId);

    /**
     * 修改用户
     * @param pet
     * @return
     */

    /**
     * 修改
     * @param pet
     * @return
     */
    Integer updatePet(Pet pet);


    /**
     * 根据ID  获得用户对象
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
