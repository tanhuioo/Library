package com.bysj.qiu.controller;

import com.bysj.qiu.pojo.Secret;
import com.bysj.qiu.service.GetSecretService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class ManageController {
    private ModelAndView modelAndView;
    @Autowired
    GetSecretService getSecretService;

    //根据不同的用户跳到不同的界面
    @RequestMapping("/continue")
    public ModelAndView doLogin(RedirectAttributes redirectAttributes) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        authentication.getAuthorities();
        System.out.println("quanxian" + authentication.getAuthorities());
        String s = authentication.getAuthorities().toString();
        switch (s) {
            case "[ROLE_ADMIN]":
                modelAndView = new ModelAndView("redirect:/admin/first");
                break;
            case "[ROLE_USER]":
                modelAndView = new ModelAndView("redirect:/other/first");
                break;

            default:
//                modelAndView = new ModelAndView("redirect:/");//未登录或权限不够
                String a = "error";
                redirectAttributes.addFlashAttribute("errinfo", a);
                modelAndView = new ModelAndView("redirect:/");
                break;
        }
        return modelAndView;

    }

    //判断权限
    @RequestMapping("/booleanPower")
    @ResponseBody
    public String booleanPower(String user, String password) {
        Secret usersecret = getSecretService.booleanUserPower(user, password);
        Secret adminsecret = getSecretService.booleanAdminPower(user, password);
        if (usersecret != null) {
            return "usersecret";
        } else if (adminsecret != null) {
            return "adminsecret";
        } else {
            return "none";
        }
    }

    //    注册
    @RequestMapping("/regist")
    @ResponseBody
    public int regist(String userregist, String passwordregist) {
        int regist = getSecretService.regist(userregist, passwordregist);
        return regist;
    }


    //    判断是否数据库里已经有了这个用户
    @RequestMapping("/booleanexist")
    @ResponseBody
    public String booleanexist(String userregist) {
        Secret secret = getSecretService.selOtherUserPower(userregist);
        Secret secretadmin = getSecretService.selAdminPower(userregist);
        if (secret != null || secretadmin != null) {
            System.out.println(secret);
            return "dead";
        } else {
            System.out.println(secret);
            return "left";
        }

    }


    //让index作为首页
    @RequestMapping("/")
    public String index() {
        return "/index";
    }


}


