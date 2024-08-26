package com.smart.helper;

import com.smart.entity.Contect;
import com.smart.entity.Users;

public class Converter {

	
	public static Users userHelperToUser(UserHelper helper) {
		Users user = new Users();
		user.setUserId(helper.getUserId());
		user.setEmail(helper.getEmail());
		user.setPassword(helper.getPassword());
		user.setRole(helper.getRole());
		user.setUserName(helper.getUserName());
		user.setIsEnable(helper.getIsEnable());
		user.setAbout(helper.getAbout());
		user.setImage(helper.getImage());
		return user;
	}
	
	public static UserHelper  userToUserHelper(Users	 helper) {
		UserHelper user = new UserHelper();
		user.setUserId(helper.getUserId());
		user.setEmail(helper.getEmail());
		user.setPassword(helper.getPassword());
		user.setRole(helper.getRole());
		user.setUserName(helper.getUserName());
		user.setIsEnable(helper.getIsEnable());
		user.setAbout(helper.getAbout());
		user.setImage(helper.getImage());
		 
		return user;
	}
	
	public static ContectHelper  contectToContectHelper(Contect helper) {
		ContectHelper contect = new ContectHelper();
		contect.setContectId(helper.getContectId());
		contect.setEmail(helper.getEmail());
		contect.setNickName(helper.getNickName());
		contect.setPhoneNumber(helper.getPhoneNumber());
		contect.setUserName(helper.getUserName());
		contect.setWorking(helper.getWorking());
		contect.setAbout(helper.getAbout());
		contect.setDate(helper.getCreationDate());
		 
		return contect;
	}
	
	public static Contect  contectHelperToContect(ContectHelper helper) {
		Contect contect = new Contect();
		contect.setContectId(helper.getContectId());
		contect.setEmail(helper.getEmail());
		contect.setNickName(helper.getNickName());
		contect.setPhoneNumber(helper.getPhoneNumber());
		contect.setUserName(helper.getUserName());
		contect.setWorking(helper.getWorking());
		contect.setAbout(helper.getAbout());
		 
		return contect;
	}
	
	
}
