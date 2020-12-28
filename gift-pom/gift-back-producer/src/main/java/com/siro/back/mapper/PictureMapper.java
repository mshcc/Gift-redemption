package com.siro.back.mapper;

import com.siro.model.Category;
import com.siro.model.Picture;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PictureMapper {
    /**
     * delete by primary key
     *
     * @param id primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * insert record to table
     *
     * @param record the record
     * @return insert count
     */
    int insert(Picture record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(Picture record);

    /**
     * select by primary key
     *
     * @param id primary key
     * @return object by primary key
     */
    Picture selectByPrimaryKey(Integer id);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(Picture record);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(Picture record);

    List<Picture> findPictureByCategoryAndCategoryId(Category category);

    int deleteByRangeId(Integer id);

}