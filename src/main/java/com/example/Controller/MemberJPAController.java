package com.example.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Dao.MemberRepositoryJPA;
import com.example.Model.MemberAccountJPA;

@ComponentScan(basePackages = {"com.example.Model"})

// @RestController
@Controller
public class MemberJPAController {
    
    @Autowired
    MemberRepositoryJPA memberRepositoryJPA;

    @Autowired
    DataSource dataSource;

    List<MemberAccountJPA> memberAccountJPA= new ArrayList<MemberAccountJPA>();

    @RequestMapping("/addMemberJPAPage")
    public String addMemberJPAPage(){


        
		memberAccountJPA = memberRepositoryJPA.findAll();

		for(int i=0;i<memberAccountJPA.size();i++){
			System.out.println(memberAccountJPA.get(i).getId());
		}
        
        return "addMemberJPA";
    }

    @RequestMapping("/addMemberJPA.do")
    public String addMemberJPAProcess(
        @Param("email") String email,
        @Param("password") String password,
        @Param("address") String address,
        @Param("cellphone") String cellphone
    ){
        try{
            int addMemberreturn = memberRepositoryJPA.addMemberProcess(memberAccountJPA.size()+1, email, password, address, cellphone);
            return "addMemberSuccess";
        

            
        }catch(Exception ex){
            return "error";
        }
    }

}
