package com.biz.service.impl;

import com.biz.dao.FileRecordMapper;
import com.biz.entity.FileRecord;
import com.biz.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FileServiceImpl implements FileService {

    @Autowired
    private FileRecordMapper fileRecordMapper;


    @Override
    public boolean saveFileRecord(FileRecord record) {

        int c = fileRecordMapper.insertSelective(record);

        if(c == 1) {
            return true;
        }

        return false;
    }


}
