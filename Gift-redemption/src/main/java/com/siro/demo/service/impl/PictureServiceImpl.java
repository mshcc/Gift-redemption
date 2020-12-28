package com.siro.demo.service.impl;

import com.siro.demo.model.Category;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.siro.demo.model.Picture;
import com.siro.demo.mapper.PictureMapper;
import com.siro.demo.service.PictureService;

import java.util.List;

@Service
public class PictureServiceImpl implements PictureService {

    @Resource
    private PictureMapper pictureMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return pictureMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Picture record) {
        return pictureMapper.insert(record);
    }

    @Override
    public int insertSelective(Picture record) {
        return pictureMapper.insertSelective(record);
    }

    @Override
    public Picture selectByPrimaryKey(Integer id) {
        return pictureMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Picture record) {
        return pictureMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Picture record) {
        return pictureMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Picture> findPictureByCategoryAndCategoryId(Category category) {
        return pictureMapper.findPictureByCategoryAndCategoryId(category);
    }

    @Override
    public int deleteByRangeId(Integer id) {
        return pictureMapper.deleteByRangeId(id);
    }


}
