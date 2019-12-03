package com.example.waterpurifiermanagementsystem.controller;

import com.example.waterpurifiermanagementsystem.pojo.Record;
import com.example.waterpurifiermanagementsystem.service.RecordService;
import com.example.waterpurifiermanagementsystem.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/record")
public class RecordController {
    @Autowired
    private RecordService recordService;

    @PostMapping("/findAll")
    public Result findAll(Integer page,Integer rows){
        return recordService.findAll(page,rows);
    }

    @PostMapping("/findImport")
    public Result findImport(Integer page,Integer rows){
        return recordService.findImport(page,rows);
    }

    @PostMapping("/insert")
    public Result insert(Record record){
        return recordService.insert(record);
    }

    @PostMapping("/update")
    public Result update(Record record){
        return recordService.update(record);
    }

    @PostMapping("/delete")
    public Result delete(Integer id){
        return recordService.delete(id);
    }
}
