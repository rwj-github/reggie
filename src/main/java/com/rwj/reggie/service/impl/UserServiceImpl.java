package com.rwj.reggie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rwj.reggie.mapper.UserMapper;
import com.rwj.reggie.pojo.User;
import com.rwj.reggie.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 * @author rwj
 * @create 2022-08-11 11:11
 */
@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Value("${spring.mail.username}")
    private String from;//邮件发送人
    @Autowired
    private JavaMailSender mailSender;
    @Override
    public void sendMsg(String phone, String subject, String context) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(from);
        mailMessage.setTo(phone);
        mailMessage.setSubject(subject);
        mailMessage.setText(context);
        mailSender.send(mailMessage);
    }
}
