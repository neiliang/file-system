package com.biz.listeners;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class SysStartListener implements ApplicationListener<ContextRefreshedEvent> {

    private static final Logger logger = LoggerFactory.getLogger(SysStartListener.class);



    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        System.out.println("SysStartListener ===================================================> onApplicationEvent");

        // 启动后加载"定时任务"的配置
        if( contextRefreshedEvent instanceof ContextRefreshedEvent){
            // 查询数据库，加载相关信息 ...

            logger.info("==================>项目启动后加载的数据："+ JSONObject.toJSONString(""));
        }


    }



}
