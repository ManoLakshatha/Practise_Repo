package com.backend.Backendconnection.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import static com.backend.Backendconnection.constants.ValueConstants.users_collection;

@Document(users_collection)
public class RegisterUsers {

	@Id
	private String id;
	private String userName;
	private String password;
	private String cpassword;
	private String email;

	public RegisterUsers() {

		// TODO Auto-generated constructor stub
	}
	

	public RegisterUsers(String id, String userName, String password, String cpassword, String email) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.cpassword = cpassword;
		this.email = email;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCpassword() {
		return cpassword;
	}

	public void setCpassword(String cpassword) {
		this.cpassword = cpassword;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	 

	 

}