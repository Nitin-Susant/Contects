package com.smart.helper;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

 
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class ContectHelper {

	 
	Integer contectId;
	String userName;
	String nickName;
	String phoneNumber;
	String about;
	String image;
	String working;
	String email;
    LocalDate date;
	 String cars;
	
}
