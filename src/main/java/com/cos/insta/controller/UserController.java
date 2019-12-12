package com.cos.insta.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.cos.insta.model.User;
import com.cos.insta.repository.FollowRepository;
import com.cos.insta.repository.UserRepository;
import com.cos.insta.service.MyUserDetail;

@Controller
public class UserController {
	
	
	  @Autowired 
	  private UserRepository mUserRepository;
	  
	  @Autowired
	  private BCryptPasswordEncoder encoder;
	 
	  @Autowired
	  private FollowRepository mFollowRepository;	
	  
	@GetMapping("/auth/join")
	public String authJoin(User user) {
		return"auth/join";
	}
	@GetMapping("/auth/login")
	public String authLogin() {
		return "auth/login";
	}

	  @PostMapping("/auth/joinProc")
	  public String authJoinProc(User user) {
		  String rawPassword = user.getPassword();
		  String encPassword = encoder.encode(rawPassword);
		  user.setPassword(encPassword);
		  System.out.println("rawPassword: "+rawPassword);
		  mUserRepository.save(user);
	  return "redirect:/auth/login"; 
	  }
	 
	  @GetMapping("/user/{id}")
	  public String profile(
			  @PathVariable int id,
			  @AuthenticationPrincipal MyUserDetail userDetail,
			  Model model) {
		  
		  //id를 통해서 해당 유저를 검색()
		  
		  //4번
		  Optional<User>  oUser = mUserRepository.findById(id);
		  User user = oUser.get();
		  model.addAttribute("user", user);
		  
		  //5번
		  User principal = userDetail.getUser();
		  int followCheck = mFollowRepository.countByFromUserIdAndToUserId(principal.getId(), id);
		  model.addAttribute("followCheck", followCheck);
		  return "user/profile";
	  }
	  
	  @GetMapping("/user/edit/{id}")
	  public String userEdit(@PathVariable int id) {
		  
		  
		  
		  return "user/profile_edit";
	  }
}
