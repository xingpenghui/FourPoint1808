package com.qfedu.fourpoint1808.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 *@Author feri
 *@Date Created in 2019/4/26 11:48
 */
public class QuartzCar_Main {
    public static void main(String[] args) throws SchedulerException {
        //1、创建触发器  建造者模式
        Trigger trigger=TriggerBuilder.newTrigger().
                withSchedule(
                        CronScheduleBuilder.cronSchedule("0/5 10-59 * * * ?")
                ).build();
        //2、创建作业对象
        JobDetail jobDetail=JobBuilder.newJob(CarJob.class).build();
        //传递数据  数据内容、对象、集合等
        jobDetail.getJobDataMap().put("hellojob",new HelloJob());
        jobDetail.getJobDataMap().put("name","测试数据传递");

        //3、创建调度器
        Scheduler scheduler=StdSchedulerFactory.getDefaultScheduler();
        //4、设置定时作业
        scheduler.scheduleJob(jobDetail,trigger);
        //5、开启调度器
        scheduler.start();
//        scheduler.shutdown(); //关闭
//        scheduler.pauseJob(jobDetail.getKey());//暂停作业
//        scheduler.resumeJob(jobDetail.getKey());//恢复作业
//        scheduler.deleteJob(null);//删除作业
    }
}
