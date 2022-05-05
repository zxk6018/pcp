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

    @Override
    public List<Pet> findPetList(Integer page, Integer pageSize, String petName, String pettypeName) {
        Integer pyl = (page-1)*pageSize;
        return petDao.findPetList(pyl,pageSize,petName,pettypeName);
    }

    @Override
    public Integer PetCount(String petName, String pettypeName) {
        return petDao.PetCount(petName,pettypeName);
    }

    @Override
    public Integer savePet(Pet pet) {
        return petDao.savePet(pet);
    }

    @Override
    public Integer deletePetById(Integer petId) {
        return petDao.deletePetById(petId);
    }

    @Override
    public Integer updatePet(Pet pet) {
        return petDao.updatePet(pet);
    }

    @Override
    public Pet findPetById(Integer petId) {
        return petDao.findPetById(petId);
    }

    @Override
    public Integer seePet(Pet pet) {
        return petDao.seePet(pet);
    }
}
