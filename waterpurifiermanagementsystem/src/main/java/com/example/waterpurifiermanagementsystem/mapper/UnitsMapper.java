package com.example.waterpurifiermanagementsystem.mapper;

import com.example.waterpurifiermanagementsystem.pojo.Units;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UnitsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Units record);

    int insertSelective(Units record);

    Units selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Units record);

    int updateByPrimaryKey(Units record);

    List<Units> findAll();
}