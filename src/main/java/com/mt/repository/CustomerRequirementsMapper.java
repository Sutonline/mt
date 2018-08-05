package com.mt.repository;

import com.mt.pojo.CustomerRequirements;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CustomerRequirementsMapper {

    int deleteByPrimaryKey(Integer reqId);

    int insert(CustomerRequirements record);

    CustomerRequirements selectByPrimaryKey(Integer reqId);

    List<CustomerRequirements> selectAll();

    int updateByPrimaryKey(CustomerRequirements record);
}