package com.ruoyi.web;

import com.ruoyi.RuoYiApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.junit4.SpringRunner;

/*
 * eamil测试类
 * */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = RuoYiApplication.class)
public class emailTest {

    @Autowired
    private JavaMailSender javaMailSender;

    //        这里自己给自己发送
    @Test
    public void  send(){
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        //设置发送人
        mailMessage.setFrom("3079370784@qq.com");
        //邮件主题
        mailMessage.setSubject("这是一封测试邮件");
        //邮件内容
        mailMessage.setText("测试成功？");
        //收件人
        mailMessage.setTo("3079370784@qq.com");
        javaMailSender.send(mailMessage);
    }

}