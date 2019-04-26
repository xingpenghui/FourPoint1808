package com.qfedu.fourpoint1808.usedcar;

import com.qfedu.fourpoint1808.webmagic.CarProcess;
import us.codecraft.webmagic.Spider;

/**
 *@Author feri
 *@Date Created in 2019/4/25 16:28
 */
public class UsedCar_main {
    public static void main(String[] args) {
        //创建爬虫对象并设置要爬取的内容
        new Spider(new UsedCarPage()).addUrl("https://www.renrenche.com/xin/ershouche/?plog_id=90163fc12190ca31dd12bfd1712c542a")
                .addPipeline(new UsedCarPlpine()).thread(1).start();
    }
}
