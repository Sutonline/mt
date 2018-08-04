package com.mt.repository;

import com.mt.pojo.CustomerRequirements;
import java.util.List;

public interface CustomerRequirementsMapper {

    int deleteByPrimaryKey(Integer reqId);

    int insert(CustomerRequirements record);

    CustomerRequirements selectByPrimaryKey(Integer reqId);

    List<CustomerRequirements> selectAll();

    int updateByPrimaryKey(CustomerRequirements record);
}