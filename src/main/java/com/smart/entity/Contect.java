package com.smart.entity;

import java.time.LocalDate;

import org.springframework.boot.context.properties.bind.DefaultValue;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Contect {

	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer contectId;
	String userName;
	String nickName;
	String phoneNumber;
	String about;
	String image;
	String working;
	String email;
	LocalDate creationDate;
	 
	Boolean isDeleted;
	Boolean isfavroit;
	
	 @ManyToOne(fetch = FetchType.LAZY)
	 Users user;
	 
	
}
