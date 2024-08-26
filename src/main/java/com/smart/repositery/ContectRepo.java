package com.smart.repositery;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.smart.entity.Contect;
import com.smart.entity.Users;

public interface ContectRepo extends JpaRepository<Contect, Integer> {

//	@Query("from Contect as c where c.user.id = :userId")  ==HQL
	//sql
	@Query(value =  "select * from contect where user_user_id =:userId and is_deleted =:is_deleted"
			,nativeQuery = true)
	public List<Contect> findContectByuserId(@Param("userId") int userId,
			@Param("is_deleted") boolean is_deleted
			) ;
		
//	@Query(value = "select * from contect where user_name =:username",nativeQuery = true)
	public List<Contect> findByUserNameContainingAndUser(String username,Users u);
	       
	@Query(value =  "select * from contect where user_user_id =:userId and isfavroit =:isfavroit"
			,nativeQuery = true)
	public List<Contect> findByFav(@Param("userId") int userId,
			@Param("isfavroit") boolean isfavroit
			);
	 
		
	
	
}
