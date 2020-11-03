package com.biz.dao;

import com.biz.entity.UserInfo;

public interface UserInfoMapper {
    /**
     * @desc 
     * @date 2020-10-27 21:25:06
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * @desc 
     * @date 2020-10-27 21:25:06
     */
    int insert(UserInfo record);

    /**
     * @desc 
     * @date 2020-10-27 21:25:06
     */
    int insertSelective(UserInfo record);

    /**
     * @desc 
     * @date 2020-10-27 21:25:06
     */
    UserInfo selectByPrimaryKey(Integer id);

    /**
     * @desc 
     * @date 2020-10-27 21:25:06
     */
    int updateByPrimaryKeySelective(UserInfo record);

    /**
     * @desc 
     * @date 2020-10-27 21:25:06
     */
    int updateByPrimaryKey(UserInfo record);
}