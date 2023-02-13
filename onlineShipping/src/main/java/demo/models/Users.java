package demo.models;

import org.springframework.data.mongodb.core.mapping.Document;

@Document("RegisterUsers")
public class Users {

	private String userName;
	private String emailId;
	private String phoneNumber;
	private String password;
	
	public Users(String userName, String emailId, String phoneNumber, String password) {
		super();
		this.userName = userName;
		this.emailId = emailId;
		this.phoneNumber = phoneNumber;
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
