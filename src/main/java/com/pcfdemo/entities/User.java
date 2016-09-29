package com.pcfdemo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.springframework.cloud.cloudfoundry.com.fasterxml.jackson.annotation.JsonView;

@Entity
public class User {
	
	
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long userId;
	
	@NotNull
	private String name;

	@NotNull
	private String firstName;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	
	
}
