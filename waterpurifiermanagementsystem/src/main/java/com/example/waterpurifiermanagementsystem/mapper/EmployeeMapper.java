package com.example.waterpurifiermanagementsystem.mapper;


import com.example.waterpurifiermanagementsystem.pojo.Employee;
import com.example.waterpurifiermanagementsystem.vo.EmployeeExample;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Employee record);

    int insertSelective(Employee record);

    Employee selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Employee record);

    int updateByPrimaryKey(Employee record);

    List<EmployeeExample> findAll();
}