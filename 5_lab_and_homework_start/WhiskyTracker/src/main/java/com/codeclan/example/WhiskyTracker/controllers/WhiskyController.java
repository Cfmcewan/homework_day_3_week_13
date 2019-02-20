package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository.WhiskyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/whiskies")
public class WhiskyController {

    @Autowired
    WhiskyRepository whiskyRepository;


    @GetMapping
    public List<Whisky> getAllWhiskies(){
        return whiskyRepository.findAll();
    }


    @GetMapping(value= "year/{whiskyYear}")
    public List<Whisky> getAllWhiskeysByYear(@PathVariable int whiskyYear){
        return whiskyRepository.findWhiskeysByYear(whiskyYear);
    }


    @GetMapping(value= "{age}/{id}")
    public List<Whisky> getWhiskyByCertainDistilleryByCertainAge(@PathVariable String name, @PathVariable int age){
        return whiskyRepository.findWhiskyFromCertainDistilleryByCertainAge(name, age);

    }

    @GetMapping(value= "region/{region}")
    public List<Whisky> getWhiskyByRegion(@PathVariable String region){
        return whiskyRepository.findWhiskeysByRegion(region);
    }
}
