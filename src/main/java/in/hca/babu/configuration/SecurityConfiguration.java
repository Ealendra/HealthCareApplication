package in.hca.babu.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import in.hca.babu.constant.UserRoles;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
	
		
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
	.antMatchers("/patient/show","patient/save").permitAll()
		.antMatchers("/special/**").hasAnyAuthority(UserRoles.ADMIN.name())
		.antMatchers("/doctor/**").hasAnyAuthority(UserRoles.ADMIN.name())
		.antMatchers("/appointment/show","/appointment/save","/appointment/all").hasAuthority(UserRoles.ADMIN.name())
		.antMatchers("/appoint/view","/appointment/viewslots").hasAnyAuthority(UserRoles.PATIENT.name())
		.antMatchers("/user/login","/login").permitAll()
		.anyRequest().authenticated()
		//Default Log in Page
	.and()
	.formLogin()
	.loginPage("/user/login")//show login page
	.loginProcessingUrl("/login")//POST (do login)
    .defaultSuccessUrl("/user/setup",true)
    .failureUrl("/user/login ? error=true") //if login id faild.
    //Log out Page
	.and()
	.logout()
	.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))//url for logout.
	.logoutSuccessUrl("/user/login ? logout=true")//on logout success.
	
	//Exception Handling
	.and()
	.exceptionHandling()
	.accessDeniedPage("/denied")
		;
	}

}
