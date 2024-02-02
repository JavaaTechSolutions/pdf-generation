package com.jts.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DummyController {
	
	@Autowired
	private UserSerrvice userSerrvice;
	
	public DummyController(UserSerrvice userSerrvice) {
		this.userSerrvice = userSerrvice;
	}
	
	// localhost:8080/api/1
	@GetMapping("/{id}")
	public void getUserById(@PathVariable long id) {
		// Fetch data from database
	}
	
	@PostMapping("/save")
	public void saveUser(@RequestBody User user) {
		
	}

}
