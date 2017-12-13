package com.chaoren.cos.pc.controller;

import com.chaoren.aop.exception.BusinessException;
import com.chaoren.aop.safety.validatecode.ValidateCode;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class TestController{
    @RequestMapping("/test")
    public void test() {
        System.out.println("执行Test…………");
    }

    /**
     * 响应验证码页面
     *
     * @return
     */
    @RequestMapping(value = "/validateCode")
    public String validateCode(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 设置响应的类型格式为图片格式
        response.setContentType("image/jpeg");
        //禁止图像缓存。
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);

        HttpSession session = request.getSession();

        ValidateCode vCode = new ValidateCode(90, 37, 5, 100);
        session.setAttribute("code", vCode.getCode());
        vCode.write(response.getOutputStream());
        return null;
    }
    @ResponseBody
    @RequestMapping("/login")
    public void login(@RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("code") String code,
                                      HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("执行login…………" + username + "-----" + password);

        int rememberMe = 2;
        HttpSession session = request.getSession();

//        SecurityUtils.setSecurityManager(securityManager);
        Subject user = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        String errMsg = "";
        // 设置记住密码
        token.setRememberMe(1 == rememberMe);
        if(!session.getAttribute("code").equals(code)){//验证码

            throw new BusinessException(001, "验证码不正确！");
        }
        try {
            user.login(token);
            System.out.println("登陆成功！2");
        } catch (RuntimeException e) {
            System.out.println(e.getClass().getName());
            errMsg = getExMessage(e.getClass().getName());
//            response.getWriter().write(errMsg);
            throw new BusinessException(001, errMsg);
        }

    }

    public String getExMessage(String exStr) {
        if (exStr.indexOf("UnknownAccountException") != -1) {
            return "账号不存在！";
        } else if (exStr.indexOf("DisabledAccountException") != -1) {
            return "账号未启用！";
        } else if (exStr.indexOf("IncorrectCredentialsException") != -1) {
            return "密码错误！";
        } else {
            return "未知错误！";
        }
    }
}
