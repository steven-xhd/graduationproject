package com.example.waterpurifiermanagementsystem.mapper;

import com.example.waterpurifiermanagementsystem.pojo.ServiceRecord;
import com.example.waterpurifiermanagementsystem.pojo.Supplier;
import com.example.waterpurifiermanagementsystem.vo.ServiceRecordExample;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServiceRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ServiceRecord record);

    int insertSelective(ServiceRecord record);

    ServiceRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ServiceRecord record);

    int updateByPrimaryKey(ServiceRecord record);

    List<ServiceRecordExample> findAll();
}