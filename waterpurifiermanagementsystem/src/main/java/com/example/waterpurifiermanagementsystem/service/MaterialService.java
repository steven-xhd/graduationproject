package com.example.waterpurifiermanagementsystem.service;

import com.example.waterpurifiermanagementsystem.mapper.MaterialMapper;
import com.example.waterpurifiermanagementsystem.mapper.RecordMapper;
import com.example.waterpurifiermanagementsystem.pojo.Material;
import com.example.waterpurifiermanagementsystem.pojo.Record;
import com.example.waterpurifiermanagementsystem.util.Result;
import com.example.waterpurifiermanagementsystem.vo.MaterialExample;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class MaterialService {
    @Autowired
    private MaterialMapper materialMapper;
    @Autowired
    private RecordMapper recordMapper;
    @Autowired
    private Result result;

    /*
    * 分页查询全部数据
    * */
    public Result findAll(Integer page,Integer rows){
        List<MaterialExample> lists = materialMapper.findAll();
        int i = 0;
        for (MaterialExample list:lists) {
            if(list.getCount() == 0){
                lists.remove(i);
                materialMapper.deleteByPrimaryKey(list.getId());
            }
            i++;
            System.out.println(i);
        }
        if(lists != null && lists.size() > 0){
                if(page == null && rows == null){
                    return result.message(200,"success",lists);
                }
            if(page != null && rows == null){
                rows = 6;
            }
            PageHelper.startPage(page,rows);
            PageInfo<MaterialExample> materialExamplePageInfo = new PageInfo<>(materialMapper.findAll());
            int totalpage = (int) materialExamplePageInfo.getTotal();
            return result.pageMessage(200,"success",totalpage,materialExamplePageInfo.getList());
        }
        return result.message(500,"fail");

    }

    /*
    *
    * 插入数据/入库
    * */
    @Transactional
    public Result insert(Material example){
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("YY-mm-dd");
        String time = format.format(date);
        Record record = new Record();
        record.setInorout(0);
        record.setCount(example.getCount());
        record.setTypeid(example.getTypeid());
        record.setTime(date);
        List<MaterialExample> lists = materialMapper.findAll();
        //判断是否为数据库中重复的数据项，若是重复项则只改变count
        for (MaterialExample list:lists) {
            if(example.getTypeid()==list.getTypeid()&&example.getUnitid()==list.getUnitid()&&example.getSupplierid()==list.getSupplierid()&&example.getStoreid()==list.getStoreid()){
                example.setCount(list.getCount().intValue() + example.getCount().intValue());
                    materialMapper.updateByPrimaryKeySelective(example);
                    recordMapper.insertSelective(record);
                    return result.message(200,"success");
            }
        }
        //不是重复的数据则执行以下代码
        if(materialMapper.insertSelective(example) > 0){
            recordMapper.insertSelective(record);
            return result.message(200,"success");
        }
        return result.message(500,"fail");
    }
    /*
    *
    * 出库数据
    * */
    @Transactional
    public Result export(Material example){
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("YY-mm-dd");
        String time = format.format(date);
        Record record = new Record();
        record.setInorout(1);
        record.setCount(example.getCount());
        record.setTypeid(example.getTypeid());
        record.setTime(date);
        List<MaterialExample> lists = materialMapper.findAll();
        //判断是否为数据库中重复的数据项，若是重复项则只改变count
        for (MaterialExample list:lists) {
            if(example.getTypeid()==list.getTypeid()&&example.getUnitid()==list.getUnitid()&&example.getSupplierid()==list.getSupplierid()&&example.getStoreid()==list.getStoreid()){
                int count = list.getCount().intValue() - example.getCount().intValue();
                if(count < 0){
                    return result.message(500,"超出库存数量！");
                }
                example.setCount(count);
                materialMapper.updateByPrimaryKeySelective(example);
                recordMapper.insertSelective(record);
                return result.message(200,"success");
            }
        }
        return result.message(500,"没有对应的物料");
    }
    /*
    * 修改数据
    * */
    public Result update(Material example){
        if(materialMapper.updateByPrimaryKeySelective(example) > 0){
            return result.message(200,"success");
        }
        return result.message(500,"fail");
    }
    /*
    * 删除数据
    * */
    public Result delete(Integer id){
        if(id == null){
            return result.message(500,"没有按照规定传值");
        }
        if(materialMapper.deleteByPrimaryKey(id) > 0){
            return result.message(200,"success");
        }
        return result.message(500,"fail");
    }
}
