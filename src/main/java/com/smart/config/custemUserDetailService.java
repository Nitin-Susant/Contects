package com.smart.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.smart.entity.Users;
import com.smart.repositery.UserRepo;
@Component
public class custemUserDetailService implements UserDetailsService {

	@Autowired
	UserRepo urop;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		System.out.println("==================== user fetch");
		Users findbyemail = urop.findbyemail(username);
		
		if (findbyemail!=null) {
			UserDetails userDetails = User.withUsername(findbyemail.getEmail()).password(findbyemail.getPassword())
			.roles(findbyemail.getRole()).disabled(false).build();
			System.out.println(userDetails.toString());
			return userDetails;
		}
		
		return null;
	}

}
