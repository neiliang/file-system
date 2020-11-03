package com.biz.test;


import com.alibaba.fastjson.JSONObject;
import com.biz.app.FileSystemApplication;
import com.biz.entity.FileRecord;
import com.biz.entity.UserInfo;
import com.biz.service.FileService;
import com.biz.service.UserService;
import com.biz.utils.IdWorker;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {FileSystemApplication.class})
public class TestService {

    @Autowired
    private UserService userService;

    @Autowired
    private FileService fileService;

    @Autowired
    private IdWorker idWorker;

    @Test
    public void testAddFile() {

        FileRecord record = new FileRecord();

        record.setId(String.valueOf(idWorker.nextId()));
        record.setGroupName("group1");
        record.setFileName("/M00/00/00/wKjH41-X4j6ADPlDAAFxsEtzmNo508.jpg");
        record.setFileType("jpg");

        boolean result = fileService.saveFileRecord(record);


        System.out.println("新增记录结果：" + result);






    }


    @Test
    public void testQuery() {

        UserInfo userInfo = userService.getUserInfo(1);

        System.out.println("查询结果：" + JSONObject.toJSONString(userInfo));

    }


    @Test
    public void testAdd() {

        UserInfo userInfo = new UserInfo();

        for (int i = 0; i < 10; i++) {
            userInfo.setRealName("阿三" + i);
            userInfo.setIdCard("32132319920623660" + i);
            userInfo.setSex(1);
            userInfo.setPhone("1320323568"+i);
            userInfo.setMoney(new BigDecimal("13069993.33"));
            userInfo.setAddress("北京");

            boolean result = userService.saveUserInfo(userInfo);
        }


//        userInfo.setRealName("凡人歌");
//        userInfo.setIdCard("321323199206230322");
//        userInfo.setSex(0);
//        userInfo.setPhone("13203235689");
//        userInfo.setMoney(new BigDecimal("13069873.33"));
//        userInfo.setAddress("上海");
//
//        boolean result = userService.saveUserInfo(userInfo);
//
//        System.out.println("保存结果：" + result);

    }
































}
