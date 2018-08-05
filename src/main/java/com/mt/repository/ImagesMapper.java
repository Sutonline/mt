package com.mt.repository;

import com.mt.pojo.Images;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ImagesMapper {

    int deleteByPrimaryKey(Integer imageId);

    int insert(Images record);

    Images selectByPrimaryKey(Integer imageId);

    List<Images> selectAll();

    int updateByPrimaryKey(Images record);
}