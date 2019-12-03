package com.example.waterpurifiermanagementsystem.controller;

import com.example.waterpurifiermanagementsystem.pojo.MaterialType;
import com.example.waterpurifiermanagementsystem.service.MaterialTypeService;
import com.example.waterpurifiermanagementsystem.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/materialtype")
public class MaterialTypeController {
    @Autowired
    private MaterialTypeService materialTypeService;

    @PostMapping("/findAll")
    public Result findAll(Integer page,Integer rows){
        return materialTypeService.findAll(page,rows);
    }

    @PostMapping("/insert")
    public Result insert(MaterialType materialType){
        return materialTypeService.insert(materialType);
    }

    @PostMapping("/update")
    public Result update(MaterialType materialType){
        return materialTypeService.update(materialType);
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam("id[]") Integer[] id){
        return materialTypeService.delete(id);
    }
}
