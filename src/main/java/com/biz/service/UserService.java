package com.biz.service;

import com.biz.entity.UserInfo;

import java.util.List;

public interface UserService {

    boolean saveUserInfo(UserInfo userInfo);

    boolean removeUserInfo(Integer userId);

    boolean modifyUserInfo(UserInfo userInfo);

    UserInfo getUserInfo(Integer userId);

    List<UserInfo> getUserList(UserInfo userInfo, Integer pageSize,Integer pageNum);



}
