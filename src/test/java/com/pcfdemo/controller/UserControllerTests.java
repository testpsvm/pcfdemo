package com.pcfdemo.controller;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.pcfdemo.entities.User;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class UserControllerTests {

	@Autowired
	private TestRestTemplate testRestTemplate;

	/**
	 * The list of initialized users
	 */
	private User[] initializationUsers = null;

	@Before
	public void setup() {
		initializationUsers = this.testRestTemplate.getForObject("/user/insertDemo", User[].class);
	}

	@After
	public void cleanDatabase() {
		this.testRestTemplate.delete("/user", String.class);
	}

	@Test
	public void testPing() {
		final ResponseEntity<String> responseEntity = this.testRestTemplate.getForEntity("/user/help", String.class);
		assert (responseEntity.getBody().equals("User service"));
	}

	@Test
	public void testFindAll() {
		final User[] all = this.testRestTemplate.getForObject("/user", User[].class);
		assertArrayEquals(initializationUsers, all);
	}

	@Test
	public void testFindByNameContaining() {
		final String subName = "b";
		final User[] all = this.testRestTemplate.getForObject("/user/findbynamecontaining?name={name}", User[].class,
				subName);
		for (int i = 0; i < all.length; i++) {
			assertTrue("Error with " + all[i].getName(),
					all[i].getName() != null && (all[i].getName().contains(subName.toLowerCase())
							|| all[i].getName().contains(subName.toUpperCase())));
		}
	}

}
