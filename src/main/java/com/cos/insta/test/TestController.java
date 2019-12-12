package com.cos.insta.test;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.insta.model.User;
import com.cos.insta.repository.UserRepository;

@Controller
public class TestController {
	@Autowired
	private UserRepository mUserRepository;
	
	@GetMapping("/test/user/{id}")
	public @ResponseBody User testUser(@PathVariable int id) {
		Optional<User> oUser = mUserRepository.findById(id);
		User user = oUser.get();
		return user;
	}
	
	@GetMapping("/test/home")
	public String testHome() {
		return"/home";
	}
	
	
	@GetMapping("/test/login")
	public String testLogin() {
		return "auth/login";
	}
	@GetMapping("/test/join")
	public String testJoin() {
		return "auth/join";
	}
	@GetMapping("/test/profile")
	public String testProfile() {
		return "user/profile";
	}
	@GetMapping("/test/profile_edit")
	public String testProfile_edit() {
		return "user/profile_edit";
	}
	@GetMapping("/test/feed")
	public String testFeed() {
		return "image/feed";
	}
	@GetMapping("/test/imageUpload")
	public String testImageUpload() {
		return "image/image_upload";
	}
	
	
}
