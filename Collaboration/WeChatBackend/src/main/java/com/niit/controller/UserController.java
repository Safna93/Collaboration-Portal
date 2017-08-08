package com.niit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niit.dao.UserDAO;
import com.niit.model.User;
import com.niit.model.Error;

@Controller
public class UserController
{
@Autowired
private UserDAO userDAO;
//?-Any return type
@RequestMapping(value="/registeruser",method=RequestMethod.POST)
public ResponseEntity<?> registerUser(@RequestBody User user)
//To get the error message
{
	try
	{
		User duplicateUser=userDAO.validateUsername(user.getUsername());
		if(duplicateUser!= null)
		{
			Error error=new Error(2,"Username already exists...please enter different usename");
			return new ResponseEntity<Error>(error,HttpStatus.NOT_ACCEPTABLE);
		}
		User duplicateEmail=userDAO.validateEmail(user.getEmail());
		userDAO.registerUser(user);
		return new ResponseEntity<User>(user,HttpStatus.OK);
	}
	catch(Exception e)
	{
		Error error=new Error(1,"Unable to register user details" +e.getMessage());
		return new ResponseEntity<Error>(error,HttpStatus.INTERNAL_SERVER_ERROR);
	}
}


}
