package com.qfedu.fourpoint1808.webmagic;

import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.ConsolePipeline;

/**
 *@Author feri
 *@Date Created in 2019/4/25 15:56
 */
public class Hello_Main {
    public static void main(String[] args) {
        //创建爬虫对象并设置要爬取的内容
        new Spider(new HelloProcess()).addUrl("http://china.huanqiu.com/local/?agt=15438")
                .addPipeline(new ConsolePipeline()).thread(5).start();

    }
}
