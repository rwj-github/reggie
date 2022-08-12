package com.rwj.reggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.rwj.reggie.pojo.User;

/**
 * @author rwj
 * @create 2022-08-11 11:10
 */
public interface UserService extends IService<User> {
    void sendMsg(String phone, String subject, String context);
}
