
package com.top.service;

import java.util.List;

import com.top.exception.MyException;
import com.top.model.jpa.Users;


public interface IUsersService {
	 public Users findByUsername(String username)throws MyException;
	 
	 public void addUsers(String sessionKey)throws MyException;
	 
	 public List<Users>findTop10Sellers()throws MyException;
	 
	 public Users findByUserId(Long userId)throws MyException;
	 
	 public Users updateUsers(Users user)throws MyException;
}
