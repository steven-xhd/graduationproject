package com.example.waterpurifiermanagementsystem.service;

import com.example.waterpurifiermanagementsystem.mapper.StorehouseMapper;
import com.example.waterpurifiermanagementsystem.pojo.Storehouse;
import com.example.waterpurifiermanagementsystem.util.Result;
import com.example.waterpurifiermanagementsystem.vo.StoreHouseExample;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoreHouseService {
    @Autowired
    private StorehouseMapper storehouseMapper;
    @Autowired
    private Result result;

    /*
    * 传参分页查询
    * 无参查询全部复合数据
    *
    * */
    public Result findAll(Integer page,Integer rows){
        if(storehouseMapper.findAll() != null && storehouseMapper.findAll().size() > 0){
            if(page == null && rows == null){
                return result.message(200,"success",storehouseMapper.findAll());
            }
            if(page != null && rows == null){
                rows = 6;
            }
            PageHelper.startPage(page,rows);
            PageInfo<StoreHouseExample> pageInfo = new PageInfo<>(storehouseMapper.findAll());
            int total = (int)pageInfo.getTotal();
            return result.pageMessage(200,"success",total,pageInfo.getList());
        }
        return result.message(500,"fail");
    }

    /*
    * 插入数据
    * */
    public Result insert(Storehouse storehouse){
        if(storehouseMapper.insertSelective(storehouse) > 0){
            return result.message(200,"success");
        }
        return result.message(500,"fail");
    }
    /*
    * 查询全部storehouse表数据
    * */
    public Result find(){
        if(storehouseMapper.findStoreHouse() != null && storehouseMapper.findStoreHouse().size() > 0){
            return result.message(200,"success",storehouseMapper.findStoreHouse());
        }
        return result.message(500,"fail");
    }
    /*
    * 修改数据
    * */
    public Result update(Storehouse storehouse){
        if(storehouseMapper.updateByPrimaryKeySelective(storehouse) > 0){
            return result.message(200,"success");
        }
        return result.message(500,"fail");
    }

    /*
    * 删除数据
    * */
    public Result delete(Integer id){
        if(storehouseMapper.deleteByPrimaryKey(id) > 0){
            return result.message(200,"success");
        }
        return result.message(500,"fail");
    }

}
