package com.qfedu.fourpoint1808.quartz;

import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *@Author feri
 *@Date Created in 2019/4/26 11:47
 */

public class CarJob implements Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
       // System.out.println(helloJob);
        JobDetail jobDetail=jobExecutionContext.getJobDetail();
        HelloJob job= (HelloJob)jobDetail .getJobDataMap().get("hellojob");
        System.out.println(job);
        System.out.println(jobDetail.getJobDataMap().get("name"));
    }
}
