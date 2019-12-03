package com.example.waterpurifiermanagementsystem.service;

import com.example.waterpurifiermanagementsystem.mapper.ServiceRecordMapper;
import com.example.waterpurifiermanagementsystem.pojo.ServiceRecord;
import com.example.waterpurifiermanagementsystem.util.Result;
import com.example.waterpurifiermanagementsystem.vo.ServiceRecordExample;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ServiceRecordService {

    @Autowired
    private ServiceRecordMapper serviceRecordMapper;
    @Autowired
    private Result result;

    /*
    * 传参为分页查询
    * 不传参为全部数据查询
    * */
    public Result findAll(Integer page,Integer rows){
        if(serviceRecordMapper.findAll() != null && serviceRecordMapper.findAll().size() > 0){
            if(page == null && rows == null){
                return result.message(200,"success",serviceRecordMapper.findAll());
            }
            if(page != null && rows == null){
                rows = 6;
            }
            PageHelper.startPage(page,rows);
            PageInfo<ServiceRecordExample> pageInfo = new PageInfo<>(serviceRecordMapper.findAll());
            int totalcount = (int) pageInfo.getTotal();
            return result.pageMessage(200,"success",totalcount,pageInfo.getList());
        }
        return result.message(500,"fail");
    }

    /*
    * 插入数据
    * */
    public Result insert(ServiceRecord record){
        if(serviceRecordMapper.insertSelective(record) > 0){
            return result.message(200,"success");
        }
        return result.message(500,"fail");
    }

    /*
    * 修改数据
    * */
    public Result update(ServiceRecord record){
        if(serviceRecordMapper.updateByPrimaryKeySelective(record) > 0){
            return result.message(200,"success");
        }
        return result.message(500,"fail");
    }

    /*
    * 删除数据
    * */
    public Result delete(Integer id){
        if(serviceRecordMapper.deleteByPrimaryKey(id) > 0){
            return result.message(200,"success");
        }
        return result.message(500,"fail");
    }

}
