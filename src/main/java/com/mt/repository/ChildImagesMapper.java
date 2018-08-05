package com.mt.repository;

import com.mt.pojo.ChildImages;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ChildImagesMapper {

    int deleteByPrimaryKey(Integer childImageId);

    int insert(ChildImages record);

    ChildImages selectByPrimaryKey(Integer childImageId);

    List<ChildImages> selectAll();

    List<ChildImages> listByImageId(Long imageId);

    int updateByPrimaryKey(ChildImages record);

}