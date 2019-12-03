package com.example.waterpurifiermanagementsystem.mapper;

import com.example.waterpurifiermanagementsystem.pojo.Storehouse;
import com.example.waterpurifiermanagementsystem.vo.StoreHouseExample;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StorehouseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Storehouse record);

    int insertSelective(Storehouse record);

    Storehouse selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Storehouse record);

    int updateByPrimaryKey(Storehouse record);

    List<StoreHouseExample> findAll();

    List<Storehouse> findStoreHouse();
}