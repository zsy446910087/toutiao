package com.newcoder.toutiao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author:Siyu
 * @Date:Created in 下午4:43 2018/6/11
 */
@Controller
public class SettingController {
    @RequestMapping(path = {"/setting"})
    @ResponseBody
    public String setting() {
        return "Setting:OK";
    }
}
