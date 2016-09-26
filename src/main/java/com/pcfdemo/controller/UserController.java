package com.pcfdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pcfdemo.entities.User;
import com.pcfdemo.entities.UserRepository;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@RequestMapping("")
	public String ping() {
		return "user service";
	}

	@RequestMapping(path = "/findbyid", method = RequestMethod.GET)
	public User findById(@RequestParam(value = "id") Long id) {
		return userRepository.findOne(id);
	}

	@RequestMapping(path = "/insert", method = RequestMethod.GET)
	public User insert(@RequestParam(value="name") String name, @RequestParam(value="firstName") String firstName){
		final User user = new User();
		user.setName(name);
		user.setFirstName(firstName);
		return userRepository.save(user);
	}
	
	@RequestMapping(path = "/findbynamecontaining", method = RequestMethod.GET)
	public List<User> findByNameContains(@RequestParam(value="name") String name){
		return userRepository.findByNameContaining(name);
	}
	
	@RequestMapping(path = "/findall", method = RequestMethod.GET)
	public List<User> findAll(){
		return userRepository.findAll();
	}
	
}
