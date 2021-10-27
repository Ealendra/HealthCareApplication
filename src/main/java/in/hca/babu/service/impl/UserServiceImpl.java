package in.hca.babu.service.impl;

import java.util.Collections;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import in.hca.babu.entity.User;
import in.hca.babu.repository.UserRepository;
import in.hca.babu.service.UserService;

@Service
public class UserServiceImpl implements UserService,UserDetailsService
{
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Autowired
	private UserRepository repo;
	
	     @Override
	    public Integer saveUser(User user) {
	    	 //Read Generated PassWord
	    	 String pwd=user.getPassword();
	    	 //encode PassWord.
	    	String encodePwd=passwordEncoder.encode(pwd);
	    	//set back to object.
	    	user.setPassword(encodePwd);
	    	
	    	return repo.save(user).getId();
	    
	    }
	
	@Override
	public Optional<User> findByUserName(String userName) {
		

		return repo.findByUserName(userName);
	}

	@Override
	public UserDetails loadUserByUsername(String username) 
			throws UsernameNotFoundException {
		
		Optional<User> opt = findByUserName(username);
		if(!opt.isPresent())
			throw new  UsernameNotFoundException(username);
		else
		{
			User user=opt.get();
			return new org.springframework.security.core.userdetails.User(
					user.getUserName(), 
					user.getPassword(), 
					Collections.singletonList(new SimpleGrantedAuthority(user.getRole())));
		}
		
			
		
	}
}
