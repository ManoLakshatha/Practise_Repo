package demo.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;

import demo.models.Users;
import demo.repositories.UsersRepository;
import demo.services.UserInterface;

public class UserServiceImpl implements UserInterface{

	@Autowired
	private UsersRepository repo;
	
	
	public UserServiceImpl(UsersRepository repo) {
		super();
		this.repo = repo;
	}


	@Override
	public Users saveUsers(Users user) {
		
		return repo.save(user);
	}

}
