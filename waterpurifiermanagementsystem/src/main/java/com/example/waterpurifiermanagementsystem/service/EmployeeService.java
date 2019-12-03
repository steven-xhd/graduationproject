package com.example.waterpurifiermanagementsystem.service;

import com.example.waterpurifiermanagementsystem.mapper.EmployeeMapper;
import com.example.waterpurifiermanagementsystem.pojo.Employee;
import com.example.waterpurifiermanagementsystem.util.Result;
import com.example.waterpurifiermanagementsystem.vo.EmployeeExample;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;
    @Autowired
    private Result result;

    /*
    * 分页查询全部信息
    * */
    public Result findAll(Integer page,Integer rows){
        if(employeeMapper.findAll() != null && employeeMapper.findAll().size() > 0){
            if(page == null && rows == null){
                return result.message(200,"success",employeeMapper.findAll());
            }
            if(page != null && rows == null){
                rows = 6;
            }
            PageHelper.startPage(page,rows);
            PageInfo<EmployeeExample> employeeExamplePageInfo = new PageInfo<>(employeeMapper.findAll());
            int totalpage = (int)employeeExamplePageInfo.getTotal();
            return result.pageMessage(200,"success",totalpage,employeeExamplePageInfo.getList());
        }
        return result.message(500,"fail");
    }

    /*
    * 插入数据
    * */
    public Result insert(Employee employee){
        if(employeeMapper.insertSelective(employee) > 0){
            return result.message(200,"success");
        }
        return result.message(500,"fail");
    }
    /*
    * 修改数据
    * */
    public Result update(Employee employee){
        if(employeeMapper.updateByPrimaryKeySelective(employee) > 0){
            return result.message(200,"success");
        }
        return result.message(500,"fail");
    }

    /*
    * 删除
    * */
    public Result delete(Integer[] ids){
        int i;
        if(ids == null){
            return result.message(500,"没有按照规定传值");
        }
        for (i=0;i<ids.length;i++){
            employeeMapper.deleteByPrimaryKey(ids[i]);
        }
        if( i == ids.length){
            return result.message(200,"success");
        }
        return result.message(500,"fail");

    }
}
