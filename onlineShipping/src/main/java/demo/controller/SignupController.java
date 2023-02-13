package demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import demo.models.Users;
import demo.services.UserInterface;

@RestController
public class SignupController {

	@Autowired
	private UserInterface service;
	
	@PostMapping("/signup")
	public ResponseEntity<Object> createUsers(@RequestBody Users user){
		service.saveUsers(user);
		return ResponseEntity.ok().header("Custom-Header", "success").body("Successfully Created");
		
	}
}
