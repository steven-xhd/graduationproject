package com.example.waterpurifiermanagementsystem.service;

import com.example.waterpurifiermanagementsystem.mapper.CustomerMapper;
import com.example.waterpurifiermanagementsystem.pojo.Customer;
import com.example.waterpurifiermanagementsystem.util.Result;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Autowired
    private Result result;
    @Autowired
    private CustomerMapper customerMapper;

    /*
    * 查询全部顾客信息
    * */
    public Result findAll(Integer page,Integer rows){
        if(customerMapper.findAll() != null && customerMapper.findAll().size() > 0){
            if(page == null && rows == null){
                return result.message(200,"success",customerMapper.findAll());
            }
            if(page !=null && rows == null){
                rows = 6;
            }
            PageHelper.startPage(page,rows);
            PageInfo<Customer> customerPageInfo = new PageInfo<>(customerMapper.findAll());
            int totalpage = (int) customerPageInfo.getTotal();
            return  result.pageMessage(200,"success",totalpage,customerPageInfo.getList());
        }
        return result.message(500,"fail");
    }
    /*
    *
    * 插入数据
    * */
    public Result insert(Customer customer){
        if(customerMapper.insertSelective(customer) > 0){
            return result.message(200,"success");
        }
        return result.message(500,"fail");
    }
    /*
    * 修改数据
    * */
    public Result update(Customer customer){
        if(customerMapper.updateByPrimaryKeySelective(customer) > 0){
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
            customerMapper.deleteByPrimaryKey(ids[i]);
        }
        if( i == ids.length){
            return result.message(200,"success");
        }
        return result.message(500,"fail");
    }
}
