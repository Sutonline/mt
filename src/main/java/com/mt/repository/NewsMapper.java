package com.mt.repository;

import com.mt.pojo.News;
import java.util.List;

public interface NewsMapper {

    int deleteByPrimaryKey(Integer newsId);

    int insert(News record);

    News selectByPrimaryKey(Integer newsId);

    List<News> selectAll();

    int updateByPrimaryKey(News record);
}