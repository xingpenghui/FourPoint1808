package com.qfedu.fourpoint1808.webmagic;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.ArrayList;
import java.util.List;

/**
 *@Author feri
 *@Date Created in 2019/4/25 15:54
 */
public class HelloProcess implements PageProcessor {
    private Site site=Site.me().setSleepTime(100).setRetryTimes(3).setCharset("utf-8");
    @Override
    public void process(Page page) {
        //System.err.println(page.getHtml().get());
        List<String> names=page.getHtml().xpath("div[@class='fallsFlow']/ul/li/h3/a/text()").all();
        List<String> urls=page.getHtml().xpath("div[@class='fallsFlow']/ul/li/h3/a/@href").all();
        List<String> details=page.getHtml().xpath("div[@class='fallsFlow']/ul/li/h5/html()").all();
        List<String> times=page.getHtml().xpath("div[@class='fallsFlow']/ul/li/h6/html()").all();

        for(int i=0;i<names.size();i++){
//            System.err.println("标题："+names.get(i));
//            System.err.println("详情地址："+urls.get(i));
//            System.err.println("详情摘要："+details.get(i));
//            String t=times.get(i);
//            System.err.println("时间："+t.substring(t.lastIndexOf(">")+1));
        }
        System.err.println("---->"+names.size());
        if(page.getUrl().get().equals("http://china.huanqiu.com/local/?agt=15438")){

            //如果当前为第一页的内容，需要抓取其他也的内容
            List<String> pages=page.getHtml().xpath("div[@id='pages']/a/text()").all();
            System.err.println(pages);
            String last=pages.get(pages.size()-2);
            //组装对应分页的路径
            List<String> targets=new ArrayList<>();
            for(int i=2;i<=Integer.parseInt(last);i++){
                targets.add("http://china.huanqiu.com/local/"+i+".html?agt=15438");
            }
            //设置继承抓取的网址
            page.addTargetRequests(targets);
        }
    }

    //站点信息  请求网站的信息设置
    @Override
    public Site getSite() {
        return site;
    }
}
