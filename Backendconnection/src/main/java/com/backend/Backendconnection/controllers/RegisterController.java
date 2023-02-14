package com.backend.Backendconnection.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.backend.Backendconnection.models.RegisterUsers;
import com.backend.Backendconnection.repositories.RegisterRepository;
import com.backend.Backendconnection.services.RegisterServices;
import com.backend.Backendconnection.servicesImpl.RegisterServicesImpl;
import com.backend.Backendconnection.validation.PasswordEncryption;

import static com.backend.Backendconnection.validation.RegisterValidation.username;
import static com.backend.Backendconnection.validation.RegisterValidation.email;
import static com.backend.Backendconnection.validation.RegisterValidation.password;

@RestController
public class RegisterController {

	@Autowired
	private RegisterServices service;

	@Autowired
	private RegisterRepository repo;

	public RegisterController(RegisterServicesImpl service) {
		super();
		this.service = service;
	}

	public RegisterServices getService() {
		return service;
	}

	public void setService(RegisterServices service) {
		this.service = service;
	}

	@PostMapping("/register")
	public ResponseEntity<Object> saveUsers(@RequestBody RegisterUsers users) throws Exception {
		if (repo.existsByEmail(users.getEmail())) {
			return ResponseEntity.ok().header("Custom-Header", "already exist").body("Failure case");

		}
		if (users.getPassword().length() == 0) {

			return ResponseEntity.ok().header("Custom-Header", "password length").body("Failure case");

		}
		if (users.getPassword().length() < 8) {

			return ResponseEntity.ok().header("Custom-Header", "password min length").body("Failure case");

		}

		else if (!users.getPassword().equals(users.getCpassword())) {

			return ResponseEntity.ok().header("Custom-Header", "password not match").body("Failure case");

		} else {

			username(users.getUserName());
			password(users.getPassword());
			password(users.getCpassword());
			email(users.getEmail());
			PasswordEncryption.encryption(users);

			service.RegisterUsers(users);

			return ResponseEntity.ok().header("Custom-Header", "success").body("Success case");

		}

	}

	@GetMapping("/getUsers")
	public List<RegisterUsers> getAllEmployees() {

		return service.getallUsers();
	}

	@PostMapping("/login")
	public ResponseEntity<Object> loginUser(@RequestBody RegisterUsers users) throws Exception {

		if (!service.Authenticate(users.getEmail(), users.getPassword())) {

			return ResponseEntity.ok().header("Custom-Header", "failure").body("Failure case");

		} else {
			return ResponseEntity.ok().header("Custom-Header", "success").body("Success case");

		}

	}

}
