package com.example.waterpurifiermanagementsystem.controller;

import com.example.waterpurifiermanagementsystem.pojo.Customer;
import com.example.waterpurifiermanagementsystem.service.CustomerService;
import com.example.waterpurifiermanagementsystem.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping("/findAll")
    public Result findAll(Integer page,Integer rows){
        return customerService.findAll(page,rows);
    }

    @PostMapping("/insert")
    public Result insert(Customer customer){
        return customerService.insert(customer);
    }

    @PostMapping("/update")
    public Result update(Customer customer){
        return customerService.update(customer);
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam("id[]") Integer[] id){
        return customerService.delete(id);
    }
}
