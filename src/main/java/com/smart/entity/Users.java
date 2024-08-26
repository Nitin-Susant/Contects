package com.smart.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
 @Table(name = "user_table")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
//@tostring don't apply it causes lazzyinnitilizationException magya tostring
//if u apply use toString.Eclude on field
 
public class Users {

	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer userId;
	String userName;
	@Column(unique = true)
	String email;
	String password;
	String role;
	Boolean isEnable;
	String image;
	@Column(length = 500)
	String about;
 
	@ToString.Exclude
	@OneToMany(mappedBy = "user" ,fetch = FetchType.LAZY)
	List<Contect> contectlist = new ArrayList<>();
	
	 
	 
	
	
	
	
}
