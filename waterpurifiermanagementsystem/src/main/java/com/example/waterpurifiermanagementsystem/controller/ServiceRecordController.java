package com.example.waterpurifiermanagementsystem.controller;

import com.example.waterpurifiermanagementsystem.pojo.ServiceRecord;
import com.example.waterpurifiermanagementsystem.service.ServiceRecordService;
import com.example.waterpurifiermanagementsystem.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/servicerecord")
public class ServiceRecordController {
    @Autowired
    private ServiceRecordService serviceRecordService;

    @PostMapping("/findAll")
    public Result findAll(Integer page,Integer rows){
        return serviceRecordService.findAll(page,rows);
    }

    @PostMapping("/insert")
    public Result insert(ServiceRecord record){
        return serviceRecordService.insert(record);
    }

    @PostMapping("/update")
    public Result update(ServiceRecord record){
        return serviceRecordService.update(record);
    }

    @PostMapping("/delete")
    public Result delete(Integer id){
        return serviceRecordService.delete(id);
    }
}
