package com.example.waterpurifiermanagementsystem.controller;

import com.example.waterpurifiermanagementsystem.pojo.Storehouse;
import com.example.waterpurifiermanagementsystem.service.StoreHouseService;
import com.example.waterpurifiermanagementsystem.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/storehouse")
public class StoreHouseController {
    @Autowired
    private StoreHouseService storeHouseService;

    @PostMapping("/findAll")
    public Result findAll(Integer page,Integer rows){
        return storeHouseService.findAll(page,rows);
    }

    @PostMapping("/insert")
    public Result insert(Storehouse storehouse){
        return storeHouseService.insert(storehouse);
    }

    @PostMapping("/update")
    public Result update(Storehouse storehouse){
        return storeHouseService.update(storehouse);
    }

    @PostMapping("/delete")
    public Result delete(Integer id){
        return storeHouseService.delete(id);
    }

    @PostMapping("/findstorehouse")
    public Result find(){
        return storeHouseService.find();
    }
}

