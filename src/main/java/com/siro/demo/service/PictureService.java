package com.siro.demo.service;

import com.siro.demo.model.Category;
import com.siro.demo.model.Picture;

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
