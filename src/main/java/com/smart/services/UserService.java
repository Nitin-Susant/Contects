package com.smart.services;

import com.smart.helper.UserHelper;

public interface UserService {

	
	public UserHelper saveUser(UserHelper user);
	
	public UserHelper updateUser(UserHelper user);
	
	public UserHelper getUserByEmail(String email);
	
	public UserHelper getUserById(Integer id);
	
	public boolean deleteUser(Integer id);
}
