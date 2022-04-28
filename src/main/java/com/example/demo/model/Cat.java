package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.codecs.pojo.annotations.BsonId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigInteger;
import java.util.Date;

@Document("cat")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cat {

    @Id
    private BigInteger _id;

    private String name;
    private int ageInYears;
    private double weightInKilograms;
    private Date creationDate;
}
