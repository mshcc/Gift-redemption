package com.siro.demo.mapper;

import com.siro.demo.model.Exchange;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface ExchangeMapper {
    /**
     * delete by primary key
     * @param id primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * insert record to table
     * @param record the record
     * @return insert count
     */
    int insert(Exchange record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(Exchange record);

    /**
     * select by primary key
     * @param id primary key
     * @return object by primary key
     */
    Exchange selectByPrimaryKey(Integer id);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(Exchange record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(Exchange record);

    List<Exchange> findPage();

    List<Exchange> findPageByDate(Integer date);
}