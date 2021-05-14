package com.hl.bkd;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.Random;

public class TaoBaoLogin {

    public static void main(String[] args) {
        //此处填写驱动程序，前面是驱动名随浏览器改变，后面是你对应驱动程序的文件位置，我是绝对路径写法
        System.setProperty(
                "webdriver.chrome.driver",
                "F:\\IDEA\\backdoor\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //此处填写需要打开的网址，这是淘宝的登录网址
        driver.get(
                "https://login.taobao.com/member/login.jhtml");
        // 你的用户名
        String username = "18888151806";
        // 你的密码
        String password = "whl15275520080";
        //通过选择器获取元素
        WebElement usernameElement = driver.findElement(By.id("fm-login-id"));
        // 模拟用户点击用户名输入框
        usernameElement.click();
        // 设置sleep,方便观察
        Random rand = new Random();
        try {
            for (int i = 0; i < username.length(); i++) {
                // 随机睡眠0-1秒
                Thread.sleep(rand.nextInt(1000));
                // 逐个输入单个字符
                usernameElement.sendKeys("" + username.charAt(i));
            }
            WebElement passwordElement = driver.findElement(By.id("fm-login-password"));
            passwordElement.click();
            // 输入完成用户名后，随机睡眠0-3秒
            Thread.sleep(rand.nextInt(3000));
            for (int i = 0; i < password.length(); i++) {
                Thread.sleep(rand.nextInt(1000));
                passwordElement.sendKeys("" + password.charAt(i));
            }
            Actions action = new Actions(driver);
            WebElement moveButton = driver.findElement(By.id("nc_1_n1z"));
            // 移到滑块元素并悬停,不能超出框的长度，否则异常
            action.clickAndHold(moveButton);
            action.moveByOffset(254, 0).perform();
            action.release();


        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            Thread.sleep(300000);
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
        driver.quit();
    }

}

