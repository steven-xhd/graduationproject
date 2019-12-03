package com.example.waterpurifiermanagementsystem.controller;

import com.example.waterpurifiermanagementsystem.pojo.Units;
import com.example.waterpurifiermanagementsystem.service.UnitsService;
import com.example.waterpurifiermanagementsystem.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/units")
public class UnitsController {
    @Autowired
    private UnitsService unitsService;

    @RequestMapping("/findAll")
    public Result findAll(Integer page,Integer rows){
        return unitsService.findAll(page,rows);
    }

    @RequestMapping("/insert")
    public Result insert(Units units){
        return unitsService.insert(units);
    }

    @RequestMapping("/update")
    public Result update(Units units){
        return unitsService.update(units);
    }

    @RequestMapping("/delete")
    public Result delete(@RequestParam("id[]") Integer[] id){
        return unitsService.delete(id);
    }

}
