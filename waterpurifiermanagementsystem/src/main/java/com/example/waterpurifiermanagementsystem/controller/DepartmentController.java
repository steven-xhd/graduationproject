package com.example.waterpurifiermanagementsystem.controller;

import com.example.waterpurifiermanagementsystem.pojo.Department;
import com.example.waterpurifiermanagementsystem.service.DepartmentService;
import com.example.waterpurifiermanagementsystem.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/findAll")
    public Result findAll(Integer page,Integer rows){
        return departmentService.findAll(page,rows);
    }

    @PostMapping("/insert")
    public Result insert(Department department){
        return departmentService.insert(department);
    }

    @PostMapping("/update")
    public Result update(Department department){
        return departmentService.update(department);
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam("id[]") Integer[] id){
        return departmentService.delete(id);
    }
}
