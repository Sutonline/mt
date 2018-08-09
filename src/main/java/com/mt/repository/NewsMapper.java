package com.mt.repository;

import com.mt.common.PageRequest;
import com.mt.pojo.News;
import com.mt.web.view.query.NewsQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface NewsMapper {

    int deleteByPrimaryKey(Integer newsId);

    int insert(News record);

    News selectByPrimaryKey(Integer newsId);

    List<News> selectAll();

    int updateByPrimaryKey(News record);

    List<News> listPageByQuery(@Param(value = "query") NewsQuery query, @Param(value = "page") PageRequest pageRequest);

    long countByQuery(@Param(value = "query") NewsQuery query);
}