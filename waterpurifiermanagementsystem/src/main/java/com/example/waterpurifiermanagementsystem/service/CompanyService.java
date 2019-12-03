package com.example.waterpurifiermanagementsystem.service;

import com.example.waterpurifiermanagementsystem.mapper.CompanyMapper;
import com.example.waterpurifiermanagementsystem.pojo.Company;
import com.example.waterpurifiermanagementsystem.util.Result;
import com.example.waterpurifiermanagementsystem.vo.CompanyExample;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {
    @Autowired
    private CompanyMapper companyMapper;
    @Autowired
    private Result result;

    /*
    * 查询全部公司记录
    * */
    public Result findAll(Integer page,Integer rows){

        if(companyMapper.findAll() != null && companyMapper.findAll().size() > 0){
            if(page == null && rows == null){
                return result.message(200,"success",companyMapper.findAll());
            }
            if(page !=null && rows == null){
                rows = 6;
            }
            PageHelper.startPage(page,rows);
            PageInfo<CompanyExample> companyExamplePageInfo = new PageInfo<>(companyMapper.findAll());
            int totalpage = (int) companyExamplePageInfo.getTotal();
            return result.pageMessage(200,"success",totalpage,companyExamplePageInfo.getList());
        }
        return result.message(500,"fail");

    }

    /*
    * 插入数据
    * */
    public Result insert(Company company){
        if(companyMapper.insertSelective(company) > 0){
            return result.message(200,"success");
        }
        return result.message(500,"fail");
    }

    /*
    * 修改数据
    * */
    public Result update(Company company){
        if(companyMapper.updateByPrimaryKeySelective(company) > 0){
            return result.message(200,"success");
        }
        return result.message(500,"success");
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
            companyMapper.deleteByPrimaryKey(ids[i]);
        }
        if( i == ids.length){
            return result.message(200,"success");
        }
        return result.message(500,"fail");

    }
}
