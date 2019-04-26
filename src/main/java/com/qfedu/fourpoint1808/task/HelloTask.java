package com.qfedu.fourpoint1808.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 *@Author feri
 *@Date Created in 2019/4/26 10:56
 */
@Component//bena对象的创建
//@Service  //业务逻辑层
//@Repository //持久层
//@Controller //控制层
public class HelloTask {

    //设置任务时间 怎么重复执行 cron表达式
    //每天的每小时的第13分钟开始，间隔4分钟执行
    @Scheduled(cron = "0 13/4 * * * ?")
    public void hello(){
        System.out.println("你好："+System.currentTimeMillis()/1000);
    }
    //每天的早上6点和晚上8点执行
    @Scheduled(cron = "0 0 6,20 ? * * *")
    public void save(){
        System.out.println("执行");
    }
}
