package in.hca.babu.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import in.hca.babu.constant.UserRoles;
import in.hca.babu.entity.User;
import in.hca.babu.service.UserService;
import in.hca.babu.util.MyMailUtil;
import in.hca.babu.util.UserUtils;

@Component
public class MasterAccountSetupRunner implements CommandLineRunner  {
	
	@Value("${master.user.name}")
	private String displayName;
	
	@Value("${master.user.email}")
	private String userName;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserUtils userUtil;
	
	@Autowired
	private MyMailUtil mailUtil;

	
	public void run(String... args) throws Exception {
	 if(!userService.findByUserName(userName).isPresent())
	 {
		       String pwd = userUtil.genPwd();
		       User user = new User();
		       user.setDisplayName(displayName);
		       user.setUserName(userName);
		       user.setPassword(pwd);
		       user.setRole(UserRoles.ADMIN.name());
		      Integer id = userService.saveUser(user);
		      if(id!=null)
		      {
		    	 new Thread(new Runnable() 
		    			 {
		    			 public void run()
		    			 {
		    String text=" Your userName is " + userName + " password is " + pwd;
		    mailUtil.send(userName,"ADMIN ADDED",text);
		    			 }
		    			 }
		    	 
		    	).start();
		      }
		      
	 }
		
	}

}
