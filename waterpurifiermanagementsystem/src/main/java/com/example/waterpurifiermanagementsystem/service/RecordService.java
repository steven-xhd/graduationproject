package com.example.waterpurifiermanagementsystem.service;

import com.example.waterpurifiermanagementsystem.mapper.RecordMapper;
import com.example.waterpurifiermanagementsystem.pojo.Record;
import com.example.waterpurifiermanagementsystem.util.Result;
import com.example.waterpurifiermanagementsystem.vo.RecordExample;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecordService {
    @Autowired
    private RecordMapper recordMapper;
    @Autowired
    private Result result;

    /*
    * 传参为分页查询
    * 无参数为全部查询
    * 出库
    * */
    public Result findAll(Integer page,Integer rows){
        if(recordMapper.findAll() != null && recordMapper.findAll().size() > 0){
            if(page == null && rows == null){
                return result.message(200,"success",recordMapper.findAll());
            }
            if(page != null && rows == null){
                rows = 6;
            }
            PageHelper.startPage(page,rows);
            PageInfo<RecordExample> pageInfo = new PageInfo<>(recordMapper.findAll());
            int totalcount = (int) pageInfo.getTotal();
            return result.pageMessage(200,"success",totalcount,pageInfo.getList());
        }
        return result.message(500,"fail");
    }
    /*
     * 传参为分页查询
     * 无参数为全部查询
     * 入库
     * */
    public Result findImport(Integer page,Integer rows){
        if(recordMapper.findImport() != null && recordMapper.findImport().size() > 0){
            if(page == null && rows == null){
                return result.message(200,"success",recordMapper.findImport());
            }
            if(page != null && rows == null){
                rows = 6;
            }
            PageHelper.startPage(page,rows);
            PageInfo<RecordExample> pageInfo = new PageInfo<>(recordMapper.findImport());
            int totalcount = (int) pageInfo.getTotal();
            return result.pageMessage(200,"success",totalcount,pageInfo.getList());
        }
        return result.message(500,"fail");
    }
    /*
    * 插入数据
    * */
    public Result insert(Record record){
        if(recordMapper.insertSelective(record) > 0){
            return result.message(200,"success");
        }
        return result.message(500,"fail");
    }

    /*
    * 修改数据
    * */
    public Result update(Record record){
        if(recordMapper.updateByPrimaryKeySelective(record) > 0){
            return result.message(200,"success");
        }
        return result.message(500,"fail");
    }

    /*
    * 删除数据
    * */
    public Result delete(Integer id){
        if(recordMapper.deleteByPrimaryKey(id) > 0){
            return result.message(200,"success");
        }
        return result.message(500,"fail");
    }
}
