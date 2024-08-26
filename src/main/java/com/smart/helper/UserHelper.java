package com.smart.helper;

import java.util.ArrayList;
import java.util.List;

import com.smart.entity.Contect;

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

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
//@tostring don't apply it causer lazzyinnitilizationException magya tostring
//if u apply use toString.Eclude on field
@ToString
public class UserHelper {

	Integer userId;
	String userName;

	String email;
	String password;
	String role;
	Boolean isEnable;
	String image;
	String about;

	List<Contect> contectlist = new ArrayList<>();
	
}
