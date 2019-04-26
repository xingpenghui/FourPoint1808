package com.qfedu.fourpoint1808;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableScheduling //启用定时任务
public class Fourpoint1808Application {

    public static void main(String[] args) {
        SpringApplication.run(Fourpoint1808Application.class, args);
    }

}
