package com.example.waterpurifiermanagementsystem.service;

import com.example.waterpurifiermanagementsystem.mapper.UnitsMapper;
import com.example.waterpurifiermanagementsystem.pojo.Units;
import com.example.waterpurifiermanagementsystem.util.Result;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UnitsService {
    @Autowired
    private UnitsMapper unitsMapper;
    @Autowired
    private Result result;

    /*
    * 传参分页
    * 不传参查询全部数据
    * */
    public Result findAll(Integer page,Integer rows){
        if(unitsMapper.findAll() != null && unitsMapper.findAll().size() > 0){
            if(page == null && rows == null){
                return result.message(200,"success",unitsMapper.findAll());
            }
            if(page != null && rows == null){
                rows = 6;
            }
            PageHelper.startPage(page,rows);
            PageInfo<Units> pageInfo = new PageInfo<>(unitsMapper.findAll());
            int total = (int) pageInfo.getTotal();
            return result.pageMessage(200,"success",total,pageInfo.getList());
        }
        return result.message(500,"fail");
    }

    /*
    * 插入数据
    * */
    public Result insert(Units units){
        if(unitsMapper.insertSelective(units) > 0){
            return result.message(200,"success");
        }
        return result.message(500,"fail");
    }

    /*
    * 修改数据
    * */
    public Result update(Units units){
        if(unitsMapper.updateByPrimaryKey(units) > 0){
            return result.message(200,"success");
        }
        return result.message(500,"fail");

    }

    /*
    * 删除数据
    * */
    public Result delete(Integer[] ids){
        int i;
        for (i=0;i<ids.length;i++){
            unitsMapper.deleteByPrimaryKey(ids[i]);
        }
        if( i == ids.length){
            return result.message(200,"success");
        }
        return result.message(500,"fail");
    }
}
