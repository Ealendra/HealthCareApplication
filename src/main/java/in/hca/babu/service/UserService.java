package in.hca.babu.service;

import java.util.Optional;

import in.hca.babu.entity.User;

public interface UserService {

	Integer saveUser(User user);
	
	Optional<User> findByUserName(String userName);
	
	
}
