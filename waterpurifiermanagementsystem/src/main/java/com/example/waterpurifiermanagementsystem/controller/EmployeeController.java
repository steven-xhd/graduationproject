package com.example.waterpurifiermanagementsystem.controller;
import com.example.waterpurifiermanagementsystem.pojo.Employee;
import com.example.waterpurifiermanagementsystem.service.EmployeeService;
import com.example.waterpurifiermanagementsystem.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/findAll")
    public Result findAll(Integer page, Integer rows){
        return employeeService.findAll(page,rows);
    }

    @PostMapping("/insert")
    public Result insert(Employee employee){
        return employeeService.insert(employee);
    }

    @PostMapping("/update")
    public Result update(Employee employee){
        return employeeService.update(employee);
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam("id[]") Integer[] id){
        return employeeService.delete(id);
    }
}
