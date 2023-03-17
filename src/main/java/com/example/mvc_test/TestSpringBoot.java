package com.example.mvc_test;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;;

// Restful web Service 控制器
// = @ResponseBody + @Controller
@RestController
public class TestSpringBoot {
    
    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    // http://localhost:8080/way1?title=xxx
    
    // way1
    // 
    // @RequestParam : varName, isNeeded, defalutValue
    @RequestMapping("/way1")
    public String today(
        @RequestParam(value="title",required = false, defaultValue="OAO") String text, Model model
    ){
        model.addAttribute("name",text);
        // return "index";
        return text;
    }

    // http://localhost:8080/way2?title=xxx
    @RequestMapping("/way2/{name}")
    public ModelAndView TestSpringBoot2(
        @PathVariable("name") String urlGetName, Model model){

        // 用ModelandView控制資料模型及VIEW導向
        ModelAndView modelAndView = new ModelAndView("/TestSpringBoot2.html");
        modelAndView.addObject("name", urlGetName);
        return modelAndView;
    }
 
    

}
