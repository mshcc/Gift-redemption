package com.siro.demo.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.siro.demo.model.Picture;
import com.siro.demo.mapper.PictureMapper;
import com.siro.demo.service.PictureService;
@Service
public class PictureServiceImpl implements PictureService{

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

}
