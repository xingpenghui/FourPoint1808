package com.qfedu.fourpoint1808.usedcar;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.ArrayList;
import java.util.List;

/**
 *@Author feri
 *@Date Created in 2019/4/26 09:50
 */
public class UsedCarPage implements PageProcessor {
    private Site site=Site.me().setRetryTimes(3).setSleepTime(10);
    @Override
    public void process(Page page) {
        //数据解析
        List<String> imgs=page.getHtml().xpath("ul[@class='js-car-list']/li/a/div[@class='img-backgound']/img/@src").all();
        List<String> names=page.getHtml().xpath("ul[@class='js-car-list']/li/a/div[@class='img-backgound']/img/@data-title").all();
        List<String> msgs=page.getHtml().xpath("ul[@class='js-car-list']/li/a/div[@class='mileage']/span/html()").all();
        List<String> prices=page.getHtml().xpath("ul[@class='js-car-list']/li/a/div[@class='tags-box']/div[@class='price']/text()").all();
        //将数据传递到结果处理器中
        page.putField("imgs",imgs);
        page.putField("names",names);
        page.putField("msgs",msgs);
        page.putField("prices",prices);
        //继续爬取其他页面的数据
        if(page.getUrl().get().equals("https://www.renrenche.com/xin/ershouche/?plog_id=90163fc12190ca31dd12bfd1712c542a")){
            //抓取分页数据
            List<String> urls=page.getHtml().xpath("ul[@class='pagination']/li/a/text()").all();
            String pre="https://www.renrenche.com/xin/ershouche/p";
            int last=Integer.parseInt(urls.get(urls.size()-2).trim());
            List<String> targets=new ArrayList<>();
            for(int i=2;i<=last;i++){
                targets.add(pre+i+"/");
            }
            page.addTargetRequests(targets);
        }

    }

    @Override
    public Site getSite() {
        return site;
    }
}
