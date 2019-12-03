package com.example.waterpurifiermanagementsystem.controller;

import com.example.waterpurifiermanagementsystem.pojo.Supplier;
import com.example.waterpurifiermanagementsystem.service.SupplierService;
import com.example.waterpurifiermanagementsystem.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/supplier")
public class SupplierController {
    @Autowired
    private SupplierService supplierService;

    @PostMapping("/findAll")
    public Result findAll(Integer page,Integer rows){
        return supplierService.findAll(page,rows);
    }

    @PostMapping("/insert")
    public Result insert(Supplier supplier){
        return supplierService.insert(supplier);
    }

    @PostMapping("/update")
    public Result update(Supplier supplier){
        return supplierService.update(supplier);
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam("id[]") Integer[] id){
        return supplierService.delete(id);
    }
}
