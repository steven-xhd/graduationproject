package com.example.waterpurifiermanagementsystem.mapper;

import com.example.waterpurifiermanagementsystem.pojo.Record;
import com.example.waterpurifiermanagementsystem.vo.RecordExample;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Record record);

    int insertSelective(Record record);

    Record selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Record record);

    int updateByPrimaryKey(Record record);

    List<RecordExample> findAll();

    List<RecordExample> findImport();
}