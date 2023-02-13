package demo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import demo.models.Users;

public interface UsersRepository extends MongoRepository<Users,String> {

}
