package com.niit.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niit.dao.UserDAO;
import com.niit.model.Error;
import com.niit.model.User;
@Controller
public class MyController
{
	@Autowired
	private UserDAO userdao;
	@RequestMapping(value="/getmydetails/{fromId}",method=RequestMethod.GET)
	public ResponseEntity<?> getUserDetails(@PathVariable String fromId,HttpSession session){
		if(session.getAttribute("username")==null){
			Error error=new Error(5,"UnAuthroized User");
			return new ResponseEntity<Error>(error,HttpStatus.UNAUTHORIZED);
		}
		User user=userdao.getUserByUsername(fromId);
		return new ResponseEntity<User>(user,HttpStatus.OK);
	}
}
