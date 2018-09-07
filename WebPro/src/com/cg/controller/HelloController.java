package com.cg.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.model.Message;

@RestController
public class HelloController {
	
	@RequestMapping(value="/")
	public String sayHello(){
		
		return "Hello from Spring Controller";
	}
	
	@RequestMapping(value="/Message")
	public Message sendMessage() {
		
		Message msg=new Message();
		msg.setText("You have got a message from msg...");
		return msg;
	}
}
