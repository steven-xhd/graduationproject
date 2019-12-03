package com.example.waterpurifiermanagementsystem.controller;

import com.example.waterpurifiermanagementsystem.pojo.Company;
import com.example.waterpurifiermanagementsystem.service.CompanyService;
import com.example.waterpurifiermanagementsystem.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/company")
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    @PostMapping("/findAll")
    public Result findAll(Integer page,Integer rows){
        return companyService.findAll(page,rows);
    }

    @PostMapping("/insert")
    public Result insert(Company company){
        return companyService.insert(company);
    }

    @PostMapping("/update")
    public Result update(Company company){
        return companyService.update(company);
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam("id[]") Integer[] id){
        return companyService.delete(id);
    }
}
