package BikeServiceproject.ZelousBikeserviceproject;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity


public class Applictionconfiguration {
	@Bean
	public PasswordEncoder encoder()
	{
		return new BCryptPasswordEncoder();
	}

	@Bean
	public InMemoryUserDetailsManager uservalues()
	{
		UserDetails user1=User.withUsername("barath")
				.password(encoder().encode("Manojkumar123"))
				.roles("USER").build();
		UserDetails user2=User.withUsername("varson")
				.password(encoder().encode("Thivinkanth123"))
				.roles("USER").build();

		return new InMemoryUserDetailsManager(user1,user2);
	}

	@Bean
	public SecurityFilterChain safety(HttpSecurity hp) throws Exception
	{
		hp
		.authorizeRequests()
		.antMatchers("/mybikeproject")
		.authenticated();
		hp.csrf().disable();
		hp.formLogin();
		hp.httpBasic();

		return hp.build();

	}


}
	