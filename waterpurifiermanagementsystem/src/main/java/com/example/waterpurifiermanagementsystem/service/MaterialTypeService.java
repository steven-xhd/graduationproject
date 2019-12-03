package com.example.waterpurifiermanagementsystem.service;

import com.example.waterpurifiermanagementsystem.mapper.MaterialTypeMapper;
import com.example.waterpurifiermanagementsystem.pojo.MaterialType;
import com.example.waterpurifiermanagementsystem.util.Result;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MaterialTypeService {
    @Autowired
    private MaterialTypeMapper materialTypeMapper;
    @Autowired
    private Result result;
    /*
    * 传值分页查询
    * 不传值不分页
    * */
    public Result findAll(Integer page,Integer rows){
        if(materialTypeMapper.findAll() != null && materialTypeMapper.findAll().size() > 0){
            if(page == null && rows == null){
                return result.message(200,"success",materialTypeMapper.findAll());
            }
            if(page != null && rows == null){
                rows = 6;
            }
            PageHelper.startPage(page,rows);
            PageInfo<MaterialType> pageInfo = new PageInfo<>(materialTypeMapper.findAll());
            int totalcount = (int) pageInfo.getTotal();
            return result.pageMessage(200,"success",totalcount,pageInfo.getList());
        }
        return result.message(500,"fail");
    }

    /*
    * 插入数据
    * */
    public Result insert(MaterialType materialType){
        if(materialTypeMapper.insertSelective(materialType) > 0){
            return result.message(200,"success");
        }
        return result.message(500,"fail");
    }

    /*
    * 修改数据
    * */
    public Result update(MaterialType materialType){
        if(materialTypeMapper.updateByPrimaryKeySelective(materialType) > 0){
            return result.message(200,"success");
        }
        return result.message(500,"fail");
    }

    /*
    * 删除数据
    * */
    public Result delete(Integer[] ids){
        int i;
        if(ids == null){
            return result.message(500,"没有按照规定传值");
        }
        for (i=0;i<ids.length;i++){
            materialTypeMapper.deleteByPrimaryKey(ids[i]);
        }
        if( i == ids.length){
            return result.message(200,"success");
        }
        return result.message(500,"fail");
    }
}
