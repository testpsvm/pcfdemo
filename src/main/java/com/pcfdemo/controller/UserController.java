package com.pcfdemo.controller;

import java.util.ArrayList;
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
		return "User service CI2";
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
	 * Returns all users with a name that contains the request parameter
	 * 
	 * @param name
	 * @return
	 */
	@RequestMapping(path = "/findbynamecontainingnot", method = RequestMethod.GET)
	public List<User> findByNameContainingNot(@RequestParam String name) {
		return userRepository.findByNameContainingNot(name);
	}

	/**
	 * Returns all users with a name that contains the request parameter
	 * 
	 * @param name
	 * @return
	 */
	@RequestMapping(path = "/findbynamecontaining", method = RequestMethod.GET)
	public List<User> findByNameContaining(@RequestParam String name) {
		return userRepository.findByNameContainingIgnoreCase(name);
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

	/**
	 * Deletes a user by id
	 * 
	 * @return
	 */
	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	public String delete(@PathVariable Long id) {
		userRepository.delete(id);
		return "ok";
	}

	/**
	 * Deletes all users
	 * 
	 * @return
	 */
	@RequestMapping(path = "", method = RequestMethod.DELETE)
	public String delete() {
		userRepository.deleteAll();
		return "ok";
	}

	/**
	 * Inserts data for test<br>
	 * This method is used for doing some test from the GitHub readme.MD
	 * page<br>
	 * It should not belong in a true application
	 * 
	 * @return
	 */
	@RequestMapping(path = "/insertDemo", method = RequestMethod.GET)
	public List<User> insertDemo() {
		final List<User> users = new ArrayList<>();
		User u1 = new User();
		u1.setName("Baroud");
		u1.setFirstName("Bill");
		users.add(u1);
		User u2 = new User();
		u2.setName("Larcenet");
		u2.setFirstName("Manu");
		users.add(u2);
		User u3 = new User();
		u3.setName("Tergal");
		u3.setFirstName("Jean-Claude");
		users.add(u3);
		User u4 = new User();
		u4.setName("Bidochon");
		u4.setFirstName("Robert Eugène Louis");
		users.add(u4);
		User u5 = new User();
		u5.setName("Bidochon (née Galopin)");
		u5.setFirstName("Raymonde Jeanne Martine");
		users.add(u5);
		return userRepository.save(users);
	}

	/**
	 * Deletes all users<br>
	 * This method is used for doing some test from the GitHub readme.MD
	 * page<br>
	 * It should not belong in a true application
	 * 
	 * @return
	 */
	@RequestMapping(path = "/deleteAll", method = RequestMethod.GET)
	public String deleteAll() {
		userRepository.deleteAll();
		return "ok";
	}

}
