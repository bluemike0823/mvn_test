package com.example.mvc_test;

import java.util.Map;

import org.springframework.beans.factory.annotation.*;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.Service.*;

// 由於Sprint無法補抓Service等資料夾
// 改用Scan等方式
// 問題1
@ComponentScan(basePackages = {"com.example.Service","com.example.Dao","com.example.Model","com.example.Controller"})
@RestController
public class UserController {
    
    // 通過 Autowired 可令Spring自動把需要的對象自容器中拉出
    // 用於依賴注入
    // 將UserService的Bean自動注入到UserController
    // 使UserController 有UserService的功能
    @Autowired
    UserService userService;

    @GetMapping("/z")
    public String index(Map<String, Object> model){
        System.out.println("UserController");
        model.put("ID", userService.getUserId());
        // new ModelAndView(,,)
        System.out.println("getUserId success");
        return "index";
    }
}
