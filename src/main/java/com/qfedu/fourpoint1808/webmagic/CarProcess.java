package com.qfedu.fourpoint1808.webmagic;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.Arrays;
import java.util.List;

/**
 *@Author feri
 *@Date Created in 2019/4/25 16:22
 */
public class CarProcess implements PageProcessor {
    private Site site=Site.me().setRetryTimes(3).setSleepTime(10);
    @Override
    public void process(Page page) {
        List<String> imgs=page.getHtml().xpath("ul[@class='js-car-list']/li/a/div[@class='img-backgound']/img/@src").all();
        List<String> names=page.getHtml().xpath("ul[@class='js-car-list']/li/a/div[@class='img-backgound']/img/@data-title").all();
        List<String> msgs=page.getHtml().xpath("ul[@class='js-car-list']/li/a/div[@class='mileage']/span/html()").all();
        List<String> prices=page.getHtml().xpath("ul[@class='js-car-list']/li/a/div[@class='tags-box']/div[@class='price']/text()").all();
//        System.err.println(imgs);
//        System.err.println(names);
//        System.err.println(msgs);
        for(int i=0;i<msgs.size();i++){
            String r=msgs.get(i);
            String[] arr=r.split("<em class=\"separator\">/</em>");
            System.out.println(arr[0]);
            System.out.println(arr[1].substring(0,arr[1].indexOf('万')));
            System.out.println(arr[2]);

        }
        //System.err.println(prices);

    }

    @Override
    public Site getSite() {
        return site;
    }
}
