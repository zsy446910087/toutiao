package com.newcoder.toutiao.controller;


import com.newcoder.toutiao.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * @Author:Siyu
 * @Date:Created in 下午3:49 2018/6/6
 */
@Controller
public class IndexController {
    @RequestMapping(path = {"/", "/index"})
    @ResponseBody
    public String index() {
        return "Hello NowCoder";
    }

    @RequestMapping(value = {"/profile/{groupId}/{userId}"})
    @ResponseBody
    public String profile(@PathVariable("groupId") String groupId,
                          @PathVariable("userId") int userId,
                          @RequestParam(value = "type", defaultValue = "1") int type,
                          @RequestParam(value = "key", defaultValue = "nowcoder") String key) {
        return String.format("{%s},{%d},{%d},{%s}", groupId, userId, type, key);
    }

    @RequestMapping(path = {"/ftl"})
    public String news(Model model) {
        model.addAttribute("value1", "vv1");
        List<String> colors = Arrays.asList(new String[]{"RED", "GREED", "BLUE"});
        Map<String, String> map = new HashMap<String, String>();
        for (int i = 0; i < 4; i++) {
            map.put(String.valueOf(i), String.valueOf(i * i));
        }
        model.addAttribute("colors", colors);
        model.addAttribute("map", map);
        model.addAttribute("user", new User("Jim"));
        return "news";
    }

    @RequestMapping(value = {"/request"})
    @ResponseBody
    public String request(HttpServletRequest request,
                          HttpServletResponse response,
                          HttpSession session) {
        StringBuffer sb = new StringBuffer();
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String name = headerNames.nextElement();
            sb.append(name + ":" + request.getHeader(name) + "<br>");

        }
        /*for(Cookie cookie:request.getCookies()) {
            sb.append("Cookie:");
            sb.append(cookie.getName());
            sb.append(":");
            sb.append(cookie.getValue());
            sb.append("<br>");
        }*/
        sb.append("getMethod:" + request.getMethod() + "<br>");
        sb.append("getPathInfo:" + request.getPathInfo() + "<br>");
        sb.append("getQueryString:" + request.getQueryString() + "<br>");
        sb.append("getRequestURI:" + request.getRequestURI() + "<br>");

        return sb.toString();

    }

    @RequestMapping(value = {"/response"})
    @ResponseBody
    public String response(@CookieValue(value = "nowcoderid", defaultValue = "a") String nowcoderID,
                           @RequestParam(value = "key", defaultValue = "key") String key,
                           @RequestParam(value = "value", defaultValue = "value") String value,
                           HttpServletResponse response) {
        response.addCookie(new Cookie(key, value));
        response.addHeader(key, value);
        return "NowCoderID From Cookie:" + nowcoderID;

    }
}
