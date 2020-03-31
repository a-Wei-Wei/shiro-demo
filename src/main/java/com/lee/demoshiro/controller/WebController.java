package com.lee.demoshiro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 建议使用 burp suit进行抓包访问， 使用浏览器会返回 302 不利于直接观察
 */
@RestController
public class WebController {
    @GetMapping("/home")
    public Map<String, String> homePage() {
        Map<String, String> map = new HashMap<>();
        map.put("pageName", "home");
        map.put("loginStatus", "no");
        return map;
    }
    @GetMapping("/user/1")
    public Map<String, Object> userPage() {
        Map<String, Object> map = new HashMap<>();
        map.put("pageName", "userPage");
        map.put("loginStatus", "yes");
        return map;
    }

    @GetMapping("/hello/1")
    @ResponseBody
    public String hello() {
        return "hello";
    }
}
