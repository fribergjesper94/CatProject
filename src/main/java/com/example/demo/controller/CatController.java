package com.example.demo.controller;

import com.example.demo.model.Cat;
import com.example.demo.rabbitmq.RabbitMQConfig;
import com.example.demo.service.CatService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;


@RestController
public class CatController {

    private final CatService catService;
    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public CatController(CatService catService, RabbitTemplate rabbitTemplate) {
        this.catService = catService;
        this.rabbitTemplate = rabbitTemplate;
    }

    @PostMapping("/create")
    @ResponseBody
    public Cat createCat(@RequestBody Cat cat) {
        return catService.createCat(cat);
    }

    @GetMapping("/getAllCats")
    @ResponseBody
    public List<Cat> getAllCats () {
        return catService.findAllCats();
    }

    @GetMapping("/getCatByName/{catName}")
    @ResponseBody
    public Cat getCatByName(@PathVariable (value = "catName") String catName) {
        return catService.getCatByName(catName);
    }

    @PatchMapping("/updateCatById/{catId}")
    @ResponseBody
    public Cat updateCatById(@PathVariable (value = "catId") BigInteger catId, @RequestBody Cat cat) {
        return catService.updateCatById(catId, cat);
    }

    @DeleteMapping("/deleteCatById/{catId}")
    public void deleteCatById(@PathVariable (value = "catId") BigInteger catId) {
        catService.deleteCatById(catId);
    }


    @PostMapping("/publish")
    public String publishMessage (@RequestBody Cat cat) {
        catService.publishMessage(cat);
        rabbitTemplate.convertAndSend(
                RabbitMQConfig.TOPIC_EXCHANGE,
                RabbitMQConfig.ROUTING_KEY,
                cat);
        return "Message published";
    }
}
