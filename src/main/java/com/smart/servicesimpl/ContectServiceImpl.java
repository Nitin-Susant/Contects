package com.smart.servicesimpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.smart.entity.Contect;
import com.smart.entity.Users;
import com.smart.helper.ContectHelper;
import com.smart.helper.Converter;
import com.smart.helper.UserHelper;
import com.smart.repositery.ContectRepo;
import com.smart.repositery.UserRepo;
import com.smart.services.ContectService;

@Component
public class ContectServiceImpl implements ContectService {
	
	@Autowired
	ContectRepo contectRepo;
	
	@Autowired
	UserRepo userRepo;

	public ContectHelper saveContect(ContectHelper user,Users u) {

		Contect saveuser = Converter.contectHelperToContect(user);
		 
		System.out.println(saveuser.getIsfavroit());
		try {
			saveuser.setUser(u);
			saveuser.setCreationDate(LocalDate.now());
			saveuser.setIsDeleted(false);
			saveuser.setIsfavroit(false);
			saveuser = contectRepo.save(saveuser);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return Converter.contectToContectHelper(saveuser);

	}
	
	
	public ContectHelper updateUser(ContectHelper user) {

		Contect saveuser = Converter.contectHelperToContect(user);

		try {
			saveuser = contectRepo.save(saveuser);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return Converter.contectToContectHelper(saveuser);

	}
	
	public ContectHelper getContectById(Integer id) {

		Contect saveuser =null;

		try {
			saveuser = contectRepo.findById(id).get();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return Converter.contectToContectHelper(saveuser);

	}

	
	public List<ContectHelper> getContectByUserId(String email) {

		List<Contect> allContectsByUserId =null;
		List<ContectHelper> allByUserId =new ArrayList<>();
		Users user = userRepo.findbyemail(email);
		
		try {
			allContectsByUserId = contectRepo.findContectByuserId(user.getUserId(),false);
			allContectsByUserId.forEach(e ->{
				allByUserId.add(Converter.contectToContectHelper(e));
			});
		} catch (Exception e) {
			e.printStackTrace();
		}

		return allByUserId;

	}

	
	public List<ContectHelper> getContects() {

		List<Contect> getContect =null;
		List<ContectHelper> allContects =new ArrayList<>();
		try {
			getContect = contectRepo.findAll();
			getContect.forEach(e ->{
				allContects.add(Converter.contectToContectHelper(e));
				
			});
				
			 
		} catch (Exception e) {
			e.printStackTrace();
		}

		return allContects;

	}
	
	public boolean deleteContect(Integer id) {

		 boolean flag = false;

		try {
			Optional<Contect> byId = contectRepo.findById(id);
			Contect contect = byId.get();
			contect.setIsDeleted(true);
			contectRepo.save(contect);
			System.out.println("deleting contece ");
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return flag;

	}


	@Override
	public List<ContectHelper> getContectsByusername(String username,Users u) {
		List<Contect> contectByUsername = contectRepo.findByUserNameContainingAndUser(username,u);
		List<ContectHelper> allContects =new ArrayList<>();
		try {
		 
			contectByUsername.forEach(e ->{
				allContects.add(Converter.contectToContectHelper(e));
				
			});
				
			 
		} catch (Exception e) {
			e.printStackTrace();
		}

		return allContects;
	}


	@Override
	public boolean favContect(Integer id) {
		 
		 
		Optional<Contect> byId = contectRepo.findById(id);
		Contect contect = byId.get();
		contect.setIsfavroit(true);
		Contect save = contectRepo.save(contect);
		if (save!=null) {
			return true;
		}
		return false;
	}


	@Override
	public List<ContectHelper> getFavroit(UserHelper u) {
	 
		List<Contect> byFav = contectRepo.findByFav(u.getUserId(), true);
		List<ContectHelper> allContects =new ArrayList<>();
	 
		byFav.forEach(e ->{
			allContects.add(Converter.contectToContectHelper(e));
		});
		 
			 
		
		
		return allContects;
	}

}
