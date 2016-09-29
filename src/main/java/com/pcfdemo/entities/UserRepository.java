package com.pcfdemo.entities;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {

	/**
	 * Returns all users with a name that contains param
	 * 
	 * @param name
	 * @return
	 */
	public List<User> findByNameContainingIgnoreCase(final String name);

	/**
	 * Returns all user order by name
	 * 
	 * @return
	 */
	public List<User> findAllByOrderByName();

	/**
	 * Returns all users with a name different of the param
	 *
	 * @param name
	 * @return
	 */
	@Query("select u from User u where u.name not like %?1%")
	public List<User> findByNameContainingNot(final String name);
}
