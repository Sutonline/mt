package com.mt.repository;

import com.mt.common.PageRequest;
import com.mt.pojo.Images;
import com.mt.web.view.query.ImagesQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ImagesMapper {

    int deleteByPrimaryKey(Integer imageId);

    int insert(Images record);

    Images selectByPrimaryKey(Integer imageId);

    List<Images> selectAll();

    int updateByPrimaryKey(Images record);

    List<Images> listPageByQuery(@Param(value = "query") ImagesQuery imagesQuery, @Param(value = "page") PageRequest pageRequest);

    long countByQuery(@Param(value = "query") ImagesQuery imagesQuery);
}