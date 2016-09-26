package com.pcfdemo.entities;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>{

	public List<User> findByNameContaining(final String name);
	
}
