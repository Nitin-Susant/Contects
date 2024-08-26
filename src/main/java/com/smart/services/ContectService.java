package com.smart.services;

import java.util.List;

import com.smart.entity.Users;
import com.smart.helper.ContectHelper;
import com.smart.helper.UserHelper;

public interface ContectService {

	
	public ContectHelper saveContect(ContectHelper user,Users u) ;
	public ContectHelper updateUser(ContectHelper user);
	
	public ContectHelper getContectById(Integer id);
	
	public List<ContectHelper> getContectByUserId(String email);
	
	public List<ContectHelper> getContects();
	public List<ContectHelper> getFavroit(UserHelper u);
	public boolean deleteContect(Integer id);
	public boolean favContect(Integer id);
	
	 
	List<ContectHelper> getContectsByusername(String username, Users u);
	
}
