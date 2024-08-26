package com.smart.repositery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.smart.entity.Users;

public interface UserRepo extends JpaRepository<Users, Integer> {

	  @Query(value = "SELECT * FROM user_table where email =:email",nativeQuery = true)
	   public Users findbyemail(@Param("email") String email);  
		
	 
	
}
