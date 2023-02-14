package com.backend.Backendconnection.validation;

import org.jasypt.util.text.AES256TextEncryptor;
import org.springframework.validation.annotation.Validated;

import com.backend.Backendconnection.models.RegisterUsers;

import static com.backend.Backendconnection.constants.ValueConstants.passwordencrypt;

public class PasswordEncryption {

	public static String decode(String pswd) {
		AES256TextEncryptor aesEncryptor = new AES256TextEncryptor();
		aesEncryptor.setPassword(passwordencrypt);
		String decryptedPassword = aesEncryptor.decrypt(pswd);
		return decryptedPassword;
	}

	public static String encryption(@Validated RegisterUsers user) {
		AES256TextEncryptor aesEncryptor = new AES256TextEncryptor();
		aesEncryptor.setPassword("mypassword");
		String myEncryptedPassword = aesEncryptor.encrypt(user.getPassword());
		String myEncryptedPassword1 = aesEncryptor.encrypt(user.getCpassword());
		user.setPassword(myEncryptedPassword);
		user.setCpassword(myEncryptedPassword1);
		return "successs";
	}

}
