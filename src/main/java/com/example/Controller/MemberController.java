package com.example.Controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.Model.MemberAccount;
import com.example.Service.MemberService;



@ComponentScan(basePackages = {"com.example.Model"})
// @RestController
@Controller
public class MemberController {
    
    @Autowired
    MemberAccount memberAccount;

    @Autowired
    MemberService memberService;


    @RequestMapping(value={"/addMember.do"}, 
        params={"email","password","address","cellphone"})
    public String insertMember(
        @RequestParam("email") String email,
        @RequestParam("password") String password,
        @RequestParam("address") String address,
        @RequestParam("cellphone") String cellphone
    ){
        memberAccount = new MemberAccount(email, password,address, cellphone);
        return memberService.addMember(memberAccount);
    }



    // @RequestMapping("/getMemberDetl")
    @GetMapping("/addMemberDefault")
    public String getMemberDetl(){
        memberAccount = new MemberAccount();
    	memberAccount.setPassword("12345678");
    	memberAccount.setEmail("test@gmail.com");
    	memberAccount.setCellphone("0912345789");
    	memberAccount.setAddress("台北市");
    	// memberService.addMember(memberAccount);
        return memberService.addMember(memberAccount);
    }

    @RequestMapping("/addMember")
    public String addMember(){
        System.out.println("run addMember");
        return "addMember.html";
    }



    @GetMapping("/addMember2")
    public ModelAndView addMember2(){
        ModelAndView modelAndView = new ModelAndView("addMember.html");
        // modelAndView.addObject(getMemberDetl(), modelAndView);
        return modelAndView;
        // return "/resources/templates/FormView.html";
    }
}
