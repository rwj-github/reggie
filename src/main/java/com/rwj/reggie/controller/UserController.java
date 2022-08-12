package com.rwj.reggie.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.rwj.reggie.common.BaseContext;
import com.rwj.reggie.common.R;
import com.rwj.reggie.pojo.User;
import com.rwj.reggie.service.UserService;
import com.rwj.reggie.utils.ValidateCodeUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author rwj
 * @create 2022-08-11 11:12
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {
    @Value("${spring.mail.username}")
    private String from;
    @Autowired
    private UserService userService;
    @Autowired
    private JavaMailSender mailSender;

    @PostMapping("/sendMsg")
    public R<String> sendMsg(@RequestBody User user, HttpSession session){
        //获取邮箱账号
        String phone = user.getPhone();
        String subject = "××餐购登录验证码";
        if(StringUtils.isNotEmpty(phone)){
            //4位验证码
            String code = ValidateCodeUtils.generateValidateCode(4).toString();
            String context = "欢迎使用迅磊餐购，登录验证码为: " + code + ",五分钟内有效，请妥善保管!";
            log.info("code={}",code);
            //真正的发送邮箱验证码
            userService.sendMsg(phone,subject,context);
            session.setAttribute(phone,code);
            return R.success("验证码发送成功，请及时查看!");
        }
        return R.error("验证码发送失败，请重新输入!");
    }
    @PostMapping("/login")
    public R<User> login(@RequestBody Map map,HttpSession session){
        log.info("userMap:{}",map.toString());
        String phone = map.get("phone").toString();
        String code = map.get("code").toString();
        // 从Session中 获取保存的验证码,session 邮箱账号为 key，验证码为value
        Object codeInSession = session.getAttribute(phone);
        if(codeInSession != null && codeInSession.equals(code)){
            LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<>();
            lqw.eq(User::getPhone,phone);
            User user = userService.getOne(lqw);
            if(user == null){
                user = new User();
                user.setPhone(phone);
                user.setStatus(1);
                userService.save(user);
            }
            session.setAttribute("user",user.getId());

            return R.success(user);
        }
        return R.error("登录失败，请重新登录!");
    }
    @PostMapping("/loginout")
    public R<String> loginOut(HttpServletRequest request){
        request.getSession().removeAttribute("user");
        return R.success("安全退出成功！");
    }
}
