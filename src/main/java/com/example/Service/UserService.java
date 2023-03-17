package com.example.Service;

import org.springframework.stereotype.Service;

// 在此建立一個Bean 交由Spring管理
@Service
public class UserService {
  public Integer getUserId(){
	  System.out.println("UserService run getUserId");
	  int userId=5;
	  return userId;
  }
}