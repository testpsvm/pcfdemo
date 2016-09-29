package com.pcfdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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

	/**
	 * Returns the service name
	 * 
	 * @return
	 */
	@RequestMapping("/help")
	public String ping() {
		return "User service";
	}

	/**
	 * Returns a single using the id from the url path
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public User findById(@PathVariable Long id) {
		return userRepository.findOne(id);
	}

	/**
	 * Inserts a user using a Json description
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping(path = "", method = RequestMethod.PUT)
	public User insert(@RequestBody User user) {
		user.setUserId(null);
		return userRepository.save(user);
	}

	/**
	 * Inserts many users using a Json description
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping(path = "/all", method = RequestMethod.PUT)
	public List<User> insertAll(@RequestBody List<User> users) {
		users.stream().forEach(x -> x.setUserId(null));
		return userRepository.save(users);
	}

	/**
	 * Inserts a user using a Json description
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping(path = "/{id}", method = RequestMethod.POST)
	public User update(@PathVariable Long id, @RequestBody User user) {
		user.setUserId(id);
		return userRepository.save(user);
	}

	/**
	 * Returns all users
	 * 
	 * @return
	 */
	@RequestMapping(path = "", method = RequestMethod.GET)
	public List<User> findAll() {
		return userRepository.findAll();
	}

	/**
	 * Returns all usesr with a name that contains the request parameter
	 * 
	 * @param name
	 * @return
	 */
	@RequestMapping(path = "/findbynamecontaining", method = RequestMethod.GET)
	public List<User> findByNameContains(@RequestParam String name) {
		return userRepository.findByNameContaining(name);
	}

	/**
	 * Returns all uses sorted by name
	 * 
	 * @param name
	 * @return
	 */
	@RequestMapping(path = "/findallorderbyname", method = RequestMethod.GET)
	public List<User> findAllOrderByName() {
		return userRepository.findAllByOrderByName();
	}

}
