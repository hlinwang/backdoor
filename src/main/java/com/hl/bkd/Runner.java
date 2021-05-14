package com.hl.bkd;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.chrome.ChromeDriver;

public class Runner {
    public static void main(String[] args) {
        String taoBao = "https://www.taobao.com";
//        String taoBao = "https://login.taobao.com/member/login.jhtml";
        WebDriver webDriver = new ChromeDriver();
        Navigation navigation = webDriver.navigate();
        navigation.to(taoBao);
        Window window = webDriver.manage().window();
        window.maximize();
        try {
            Thread.sleep(1000);
            webDriver.findElement(By.linkText("亲，请登录")).click();
            Thread.sleep(1000);
            webDriver.findElement(By.linkText("密码登录")).click();
            Thread.sleep(1000);
            webDriver.findElement(By.className("weibo-login")).click();
            Thread.sleep(1000);
            webDriver.findElement(By.name("username")).sendKeys("zcyzfeng21@163.com");//****你的账号
            Thread.sleep(1000);
            webDriver.findElement(By.name("password")).sendKeys("whl18888151806");//****你的密码
            Thread.sleep(1000);
            webDriver.findElement(By.linkText("登录")).click();
            Thread.sleep(15000);
            navigation.to("https://cart.taobao.com/cart.htm");
            Thread.sleep(1000);
            webDriver.findElement(By.id("J_SelectAll1")).click();
            Thread.sleep(3000);
            while(true) {
                URL url = new URL(taoBao);// 取得资源对象
                URLConnection uc = url.openConnection();// 生成连接对象
                uc.connect();// 发出连接
                long ld = uc.getDate();// 读取网站日期时间
                Date dateNow = new Date(ld);// 转换为标准时间对象

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd-HH:mm:ss");
                String buyTime = "2021/05/15-00:00:00";
                Date dateNeed = sdf.parse(buyTime);
                if(dateNeed.equals(dateNow)||dateNeed.before(dateNow)) {
                    webDriver.findElement(By.linkText("结 算")).click();
                    System.out.println(sdf.format(dateNow));

                    webDriver.findElement(By.linkText("提交订单")).click();

                    break;
                }
            }
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
