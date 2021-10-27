package in.hca.babu.controller;

import java.security.Principal;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import in.hca.babu.entity.User;
import in.hca.babu.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	
	@GetMapping("/login")
	public String userLoginPage()
	{
		return"UserLogin";
	}
	@GetMapping("/setup")
	public String setUp(HttpSession session,Principal p)
	{
		//read Current User name.
		String username=p.getName();
		
		//load user Object.
		
		User user=userService.findByUserName(username).get();
		//store in HttpSession.
		session.setAttribute("UserObject", user);
		
		return"UserHome";
	}

}
