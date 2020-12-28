package com.siro.front.mapper;

import com.siro.model.Logistics;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LogisticsMapper {
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
    int insert(Logistics record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(Logistics record);

    /**
     * select by primary key
     *
     * @param id primary key
     * @return object by primary key
     */
    Logistics selectByPrimaryKey(Integer id);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(Logistics record);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(Logistics record);

    List<Logistics> findPage();

    List<Logistics> findPageByNotShipped();

    List<Logistics> findPageShipped();

    List<Logistics> findPageToBeCollected();

    List<Logistics> findPageHasBeenSigned();

}