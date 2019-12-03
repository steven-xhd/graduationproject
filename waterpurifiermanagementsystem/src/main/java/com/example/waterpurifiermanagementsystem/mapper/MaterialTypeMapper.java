package com.example.waterpurifiermanagementsystem.mapper;

import com.example.waterpurifiermanagementsystem.pojo.MaterialType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MaterialTypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MaterialType record);

    int insertSelective(MaterialType record);

    MaterialType selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MaterialType record);

    int updateByPrimaryKey(MaterialType record);

    List<MaterialType> findAll();

}