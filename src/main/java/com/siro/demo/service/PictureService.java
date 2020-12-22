package com.siro.demo.service;

import com.siro.demo.model.Picture;
public interface PictureService{


    int deleteByPrimaryKey(Integer id);

    int insert(Picture record);

    int insertSelective(Picture record);

    Picture selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Picture record);

    int updateByPrimaryKey(Picture record);

}
