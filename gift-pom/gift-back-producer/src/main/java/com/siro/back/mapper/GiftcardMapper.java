package com.siro.back.mapper;

import com.siro.model.Giftcard;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GiftcardMapper {
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
    int insert(Giftcard record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(Giftcard record);

    /**
     * select by primary key
     *
     * @param id primary key
     * @return object by primary key
     */
    Giftcard selectByPrimaryKey(Integer id);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(Giftcard record);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(Giftcard record);

    List<Giftcard> findPage();

    /**
     * @return 查找已兑换/过期的兑换卡
     */
    List<Giftcard> findPageExpired();

    List<Giftcard> findPageWorks();

    Giftcard findByName(String name);

    int insertList(List<Giftcard> cards);
}