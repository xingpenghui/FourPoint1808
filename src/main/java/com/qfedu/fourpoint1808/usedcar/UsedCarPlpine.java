package com.qfedu.fourpoint1808.usedcar;

import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Random;

/**
 *@Author feri
 *@Date Created in 2019/4/26 09:52
 */
public class UsedCarPlpine implements Pipeline {
    private Connection connection;
    public UsedCarPlpine(){
        try {
            //1、加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //2、获取连接
            connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/db_daydaycar?charsetEncoding=utf8&serverTimezone=UTC","root","root");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public void process(ResultItems resultItems, Task task) {
        List<String> names=resultItems.get("names");
        List<String> imgs=resultItems.get("imgs");
        List<String> msgs=resultItems.get("msgs");
        List<String> prices=resultItems.get("prices");
        Random random=new Random();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy年MM月");
        try {
            //3、获取操作对象
            PreparedStatement preparedStatement=connection.prepareStatement(
                    "insert into car(name,carimg,caryear,carkm,caraddress,carprice,caroldprice,flag,sort) values(?,?,?,?,?,?,0,1,?)");
            for(int i=0;i<names.size();i++){
                preparedStatement.setString(1,names.get(i));
                preparedStatement.setString(2,imgs.get(i));
                String r=msgs.get(i);
                String[] arr=r.split("<em class=\"separator\">/</em>");

                preparedStatement.setDate(3,new Date(sdf.parse(arr[0]).getTime()));
                preparedStatement.setString(4,Double.parseDouble(arr[1].substring(0,arr[1].indexOf('万')))*10000+"");
                preparedStatement.setString(5,arr[2].trim());
                preparedStatement.setString(6,Double.parseDouble(prices.get(i))*10000+"");
                preparedStatement.setInt(7,random.nextInt(10)+1);
                System.out.println(preparedStatement.executeUpdate());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}