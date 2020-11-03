package com.biz.service.impl;

import com.biz.dao.UserInfoMapper;
import com.biz.entity.UserInfo;
import com.biz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserInfoMapper userInfoMapper;


    @Override
    public boolean saveUserInfo(UserInfo userInfo) {

        int c = userInfoMapper.insertSelective(userInfo);

        if(c == 1) {
            return true;
        }
        return false;
    }

    @Override
    public boolean removeUserInfo(Integer userId) {
        int c = userInfoMapper.deleteByPrimaryKey(userId);
        if(c == 1) {
            return true;
        }
        return false;
    }

    @Override
    public boolean modifyUserInfo(UserInfo userInfo) {
        int c = userInfoMapper.updateByPrimaryKeySelective(userInfo);
        if(c == 1) {
            return true;
        }
        return false;
    }

    @Override
    public UserInfo getUserInfo(Integer userId) {

        return userInfoMapper.selectByPrimaryKey(userId);
    }

    @Override
    public List<UserInfo> getUserList(UserInfo userInfo, Integer pageSize, Integer pageNum) {



        return null;
    }




}
