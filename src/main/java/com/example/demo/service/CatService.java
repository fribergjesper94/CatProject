package com.example.demo.service;

import com.example.demo.errorhandler.ResourceNotFound;
import com.example.demo.model.Cat;
import com.example.demo.repository.CatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class CatService {

    private final CatRepository catRepository;

    @Autowired
    public CatService(CatRepository catRepository) {
        this.catRepository = catRepository;
    }

    public Cat createCat(Cat cat) {
        try {
            cat.setName(cat.getName());
            cat.setAgeInYears(cat.getAgeInYears());
            cat.setWeightInKilograms(cat.getWeightInKilograms());
            catRepository.save(cat);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cat;
    }

    public List<Cat> findAllCats() {
        return catRepository.findAllBy();
    }

    public Cat getCatByName(String catName) {
        return catRepository.findCatByName(catName).orElseThrow(() -> new ResourceNotFound("Cat doesn't exist"));
    }

    public Cat updateCatById(BigInteger catId, Cat cat) {
        Cat updatedCat = catRepository.findCatBy_id(catId).orElseThrow(() -> new ResourceNotFound("Cat doesn't exist"));
        updatedCat.setName(cat.getName());
        updatedCat.setAgeInYears(cat.getAgeInYears());
        updatedCat.setWeightInKilograms(cat.getWeightInKilograms());
        catRepository.save(updatedCat);
        return updatedCat;
    }

    public void deleteCatById(BigInteger catId) {
        Cat catToBeDeleted = catRepository.findCatBy_id(catId).orElseThrow(() -> new ResourceNotFound("Cat doesn't exist"));
        catRepository.delete(catToBeDeleted);
    }
}
