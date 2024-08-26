package com.smart.controllers;

import java.io.File;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.smart.entity.Users;
import com.smart.helper.ContectHelper;
import com.smart.helper.Converter;
import com.smart.helper.UserHelper;
import com.smart.services.ContectService;
import com.smart.services.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;
	@Autowired
	ContectService contectRepo;

	@GetMapping("/")
	public String base(Model m, Principal principal) {

		String email = principal.getName();

		UserHelper userByEmail = userService.getUserByEmail(email);

		m.addAttribute("user1", userByEmail);

		return "user/userprofile";
	}

	@GetMapping("/addcontect")
	public String addContect(Model m) {
		ContectHelper ct = new ContectHelper();
		ct.setCars("manash");
		ArrayList<String> arr = new ArrayList<>();
		arr.add("volvo");
		arr.add("hunday");
		arr.add("audi");
		m.addAttribute("allcars", arr);
			
		m.addAttribute("cont", ct);
		ct.setEmail("masdfn");
	 

		return "user/addContect";
	}

	@PostMapping("/savecontect")
	public String saveContact(ContectHelper contect, Model m, Principal principal) {

		String email = principal.getName();
		UserHelper userByEmail = userService.getUserByEmail(email);
		Users user = Converter.userHelperToUser(userByEmail);
 
	 
		m.addAttribute("cont", contect);
		System.out.println(contect.getCars());
		contectRepo.saveContect(contect, user);
//		return "user/addContect";
		return "redirect:/user/addcontect";
	}

//	@GetMapping("/getallcon")
//
//	public String getAllContect(Model m) {
//		List<ContectHelper> findAll = contectRepo.getContects();
//		m.addAttribute("allcontect", findAll);
//		System.out.println(findAll);
//		return "user/ContectList";
//	}

	// implinent later
	@GetMapping("/contects")
	public String getContects(Principal principal, Model m) {
		String name = principal.getName();

		List<ContectHelper> findAll = contectRepo.getContectByUserId(name);
		m.addAttribute("allcontect", findAll);
		System.out.println(findAll);
		return "user/ContectList";
	}

	@PostMapping("/deleteContect/{id}")
	public String deleteContect(@PathVariable("id") int id) {

		boolean deleteed = contectRepo.deleteContect(id);

		if (deleteed) {
			return "redirect:/user/contects";
		}
		return "redirect:/user/contects";
	}

	@PostMapping("/editContect/{id}")
	public String editContect(@PathVariable("id") int id, Model m) {

		ContectHelper contect = contectRepo.getContectById(id);

		System.out.println(contect);
		System.out.println(contect.getContectId());
		System.out.println(contect.getAbout());
		System.out.println(contect.getEmail());
		System.out.println(contect.getNickName());
		System.out.println(contect.getPhoneNumber());
		System.out.println(contect.getWorking());
		System.out.println(contect.getUserName());
		m.addAttribute("cont", contect);
		return "user/addContect";
	}

	@GetMapping("/viewprofile")
	public String viewProfile(Model m, Principal principal) {

		String email = principal.getName();
		UserHelper userByEmail = userService.getUserByEmail(email);
		m.addAttribute("user1", userByEmail);

		return "user/userprofile";
	}

 
	@PostMapping("/image_store")
	public String imageup( @RequestParam("image") MultipartFile obj ,Model m) {

		
		 System.out.println("image = "+ obj.getName());
		 
		 String newfile = "image"+File.separator + obj.getOriginalFilename();
		 File f = new File("image");
		 if (!f.exists()) {
			f.mkdir();
		}
		 
		 
		 
//		 try {
//			//Files.copy(obj.getInputStream(), Paths.get(newfile));
//			System.out.println("sucess fully ");
//		} catch (IOException e) {
//			 System.out.println("failes");
//			e.printStackTrace();
//		}
		 
		 
		 
		return "redirect:/user/viewprofile";
	}
	
	
	@GetMapping("/searchUser")
	public String searchWithNmae(@RequestParam("users") String user,Model m,Principal p) {
		 
		System.out.println("manash is good boy" + user);
		UserHelper userByEmail = userService.getUserByEmail(p.getName());
		Users User = Converter.userHelperToUser(userByEmail);
		
		List<ContectHelper> contectsByusername = contectRepo.getContectsByusername(user,User);
		m.addAttribute("allcontect", contectsByusername);
		return "user/ContectList";
	
//		return "";
	}
	
	@GetMapping("/getfav")
	public String getFavroit(Principal principal,Model m) {
		UserHelper user = getUser(principal);
		List<ContectHelper> favroit = contectRepo.getFavroit(user);
		System.out.println(favroit);
		m.addAttribute("allcontect", favroit);
		return "user/ContectList";
	}
	@PostMapping("/addfav/{id}")
	public String addFavroit(@PathVariable("id") Integer id) {
		 
		    
		    System.out.println(id);
		   contectRepo.favContect(id);
		
		return "redirect:/user/contects";
	}
	
	
	
	@ModelAttribute
	public UserHelper getUser(Principal principal) {

		String email = principal.getName();
		UserHelper userByEmail = userService.getUserByEmail(email);
		return userByEmail;
	}
	

}
