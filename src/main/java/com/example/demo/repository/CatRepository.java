package com.example.demo.repository;

import com.example.demo.model.Cat;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

public interface CatRepository extends MongoRepository<Cat, Long> {

    List<Cat> findAllBy();
    Optional<Cat> findCatByName(String name);
    Optional<Cat> findCatBy_id(BigInteger id);
}
