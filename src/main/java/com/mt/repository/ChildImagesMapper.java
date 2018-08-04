package com.mt.repository;

import com.mt.pojo.ChildImages;
import java.util.List;

public interface ChildImagesMapper {

    int deleteByPrimaryKey(Integer childImageId);

    int insert(ChildImages record);

    ChildImages selectByPrimaryKey(Integer childImageId);

    List<ChildImages> selectAll();

    List<ChildImages> listByImageId(Long imageId);

    int updateByPrimaryKey(ChildImages record);

}