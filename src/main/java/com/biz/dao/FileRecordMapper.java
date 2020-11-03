package com.biz.dao;

import com.biz.entity.FileRecord;

public interface FileRecordMapper {
    /**
     * @desc 
     * @date 2020-10-27 21:21:40
     */
    int deleteByPrimaryKey(String id);

    /**
     * @desc 
     * @date 2020-10-27 21:21:40
     */
    int insert(FileRecord record);

    /**
     * @desc 
     * @date 2020-10-27 21:21:40
     */
    int insertSelective(FileRecord record);

    /**
     * @desc 
     * @date 2020-10-27 21:21:40
     */
    FileRecord selectByPrimaryKey(String id);

    /**
     * @desc 
     * @date 2020-10-27 21:21:40
     */
    int updateByPrimaryKeySelective(FileRecord record);

    /**
     * @desc 
     * @date 2020-10-27 21:21:40
     */
    int updateByPrimaryKey(FileRecord record);
}