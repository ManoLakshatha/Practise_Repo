package demo.services;

import org.springframework.stereotype.Component;

import demo.models.Users;

@Component
public interface UserInterface {

		public Users saveUsers(Users user);
}
