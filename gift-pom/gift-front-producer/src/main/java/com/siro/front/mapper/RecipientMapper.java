package com.siro.front.mapper;

import com.siro.model.Recipient;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RecipientMapper {
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
    int insert(Recipient record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(Recipient record);

    /**
     * select by primary key
     *
     * @param id primary key
     * @return object by primary key
     */
    Recipient selectByPrimaryKey(Integer id);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(Recipient record);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(Recipient record);

    List<Recipient> findPage();

    List<Recipient> findListByName(String name);
}