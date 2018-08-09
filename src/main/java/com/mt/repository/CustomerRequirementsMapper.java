package com.mt.repository;

import com.mt.common.PageRequest;
import com.mt.pojo.CustomerRequirements;
import com.mt.web.view.query.CRQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CustomerRequirementsMapper {

    int deleteByPrimaryKey(Integer reqId);

    int insert(CustomerRequirements record);

    CustomerRequirements selectByPrimaryKey(Integer reqId);

    List<CustomerRequirements> selectAll();

    int updateByPrimaryKey(CustomerRequirements record);

    List<CustomerRequirements> listPage(@Param(value = "query") CRQuery query, @Param(value = "page") PageRequest pageRequest);

    long countByQuery(@Param(value = "query") CRQuery query);
}