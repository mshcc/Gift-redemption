package com.siro.demo.mapper;

import com.siro.demo.model.Gift;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GiftMapper {
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
    int insert(Gift record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(Gift record);

    /**
     * select by primary key
     *
     * @param id primary key
     * @return object by primary key
     */
    Gift selectByPrimaryKey(Integer id);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(Gift record);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(Gift record);

    List<Gift> findPage();

    List<Gift> findPageByDate(Integer date);

    List<Gift> findPageByRemoved();

    List<Gift> findPageByOutOfStock();

    Gift findByName(String name);
}