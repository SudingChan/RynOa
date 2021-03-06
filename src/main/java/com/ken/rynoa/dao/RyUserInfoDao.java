package com.ken.rynoa.dao;

import com.ken.rynoa.model.RyUserinfo;
import com.ken.rynoa.model.RyUserinfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RyUserInfoDao {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ry_userinfo
     *
     * @mbggenerated
     */
    int countByExample(RyUserinfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ry_userinfo
     *
     * @mbggenerated
     */
    int deleteByExample(RyUserinfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ry_userinfo
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer uid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ry_userinfo
     *
     * @mbggenerated
     */
    boolean insert(RyUserinfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ry_userinfo
     *
     * @mbggenerated
     */
    int insertSelective(RyUserinfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ry_userinfo
     *
     * @mbggenerated
     */
    List<RyUserinfo> selectByExample(RyUserinfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ry_userinfo
     *
     * @mbggenerated
     */
    RyUserinfo selectByPrimaryKey(Integer uid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ry_userinfo
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") RyUserinfo record, @Param("example") RyUserinfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ry_userinfo
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") RyUserinfo record, @Param("example") RyUserinfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ry_userinfo
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(RyUserinfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ry_userinfo
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(RyUserinfo record);
}