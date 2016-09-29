package com.pcfdemo.entities;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

	/**
	 * Returns all users with a name that contains param
	 * 
	 * @param name
	 * @return
	 */
	public List<User> findByNameContaining(final String name);

	/**
	 * Returns all user order by name
	 * 
	 * @return
	 */
	public List<User> findAllByOrderByName();
	// /**
	// * Returns all users with a name different of the param
	// *
	// * @param name
	// * @return
	// */
	// public List<User> findByNameNot(final String name);
}
