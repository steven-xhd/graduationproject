package com.example.waterpurifiermanagementsystem.controller;

import com.example.waterpurifiermanagementsystem.pojo.Material;
import com.example.waterpurifiermanagementsystem.service.MaterialService;
import com.example.waterpurifiermanagementsystem.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/material")
public class MaterialController {

    @Autowired
    private MaterialService materialService;

    @PostMapping("/findAll")
    public Result findAll(Integer page,Integer rows){
        return materialService.findAll(page,rows);
    }

    @PostMapping("/insert")
    public Result insert(Material example){
        return materialService.insert(example);
    }

    @PostMapping("/update")
    public Result update(Material material){
        return materialService.update(material);
    }

    @PostMapping("/delete")
    public Result delete(Integer id){
        return materialService.delete(id);
    }

    @PostMapping("/export")
    public Result export(Material example){
        return materialService.export(example);
    }
}
