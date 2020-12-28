package com.siro.back.service;


import com.siro.model.Category;
import com.siro.model.Picture;

import java.util.List;

public interface PictureService{


    int deleteByPrimaryKey(Integer id);

    int insert(Picture record);

    int insertSelective(Picture record);

    Picture selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Picture record);

    int updateByPrimaryKey(Picture record);

    List<Picture> findPictureByCategoryAndCategoryId(Category category);

    int deleteByRangeId(Integer id);
}
