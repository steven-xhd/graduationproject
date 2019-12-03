package com.example.waterpurifiermanagementsystem.service;

import com.example.waterpurifiermanagementsystem.mapper.DepartmentMapper;
import com.example.waterpurifiermanagementsystem.pojo.Department;
import com.example.waterpurifiermanagementsystem.util.Result;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentMapper departmentMapper;
    @Autowired
    private Result result;

    /*
    * 查询全部数据
    * */
    public Result findAll(Integer page,Integer rows){
        if(departmentMapper.findAll() != null && departmentMapper.findAll().size() > 0){
            if(page == null && rows == null){
                return result.message(200,"success",departmentMapper.findAll());
            }
            if(page != null && rows == null){
                rows = 6;
            }
            PageHelper.startPage(page,rows);
            PageInfo<Department> departmentPageInfo = new PageInfo<>(departmentMapper.findAll());
            int totalcount = (int) departmentPageInfo.getTotal();
            return result.pageMessage(200,"success",totalcount,departmentPageInfo.getList());
        }
        return result.message(500,"fail");
    }

    /*
    * 增加数据
    *
    * */
    public Result insert(Department department){
        if(departmentMapper.insertSelective(department) > 0){
            return result.message(200,"success");
        }
        return result.message(500,"fail");
    }

    /*
    * 修改数据
    * */
    public Result update(Department department){
        if(departmentMapper.updateByPrimaryKeySelective(department) > 0){
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
            departmentMapper.deleteByPrimaryKey(ids[i]);
        }
        if( i == ids.length){
            return result.message(200,"success");
        }
        return result.message(500,"fail");
    }

}
