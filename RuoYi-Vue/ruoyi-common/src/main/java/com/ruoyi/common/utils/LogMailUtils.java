package com.ruoyi.common.utils;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class LogMailUtils {
    private final JavaMailSender mailSender;

    public LogMailUtils(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    // 移除 static 关键字
    public void sendAlarmEmail(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("your-alarm@domain.com");
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        mailSender.send(message);
    }
}