package com.qfedu.fourpoint1808.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 *@Author feri
 *@Date Created in 2019/4/26 11:38
 */
public class HelloJob implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("重要的事情说三遍！！！");
    }
}
