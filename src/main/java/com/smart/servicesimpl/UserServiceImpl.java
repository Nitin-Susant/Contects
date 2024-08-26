package com.smart.servicesimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smart.entity.Users;
import com.smart.helper.Converter;
import com.smart.helper.UserHelper;
import com.smart.repositery.UserRepo;
import com.smart.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepo userRepo;

	public UserHelper saveUser(UserHelper user) {

		Users saveuser = Converter.userHelperToUser(user);
		saveuser.setIsEnable(true);
		saveuser.setRole("USER");
		 

		try {
			 
     		saveuser = userRepo.save(saveuser);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return Converter.userToUserHelper(saveuser);

	}

	public UserHelper updateUser(UserHelper user) {

		Users saveuser = Converter.userHelperToUser(user);

		try {
			saveuser = userRepo.save(saveuser);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return Converter.userToUserHelper(saveuser);

	}
	
	public UserHelper getUserByEmail(String email) {

		Users saveuser =null;

		try {
			saveuser = userRepo.findbyemail(email);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return Converter.userToUserHelper(saveuser);

	}
	
	public UserHelper getUserById(Integer id) {

		Users saveuser =null;

		try {
			saveuser = userRepo.findById(id).get();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return Converter.userToUserHelper(saveuser);

	}
	
	public boolean deleteUser(Integer id) {

		 boolean flag = false;

		try {
			userRepo.deleteById(id);
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return flag;

	}
	
}
