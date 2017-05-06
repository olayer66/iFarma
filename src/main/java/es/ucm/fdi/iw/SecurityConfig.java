package es.ucm.fdi.iw;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
        		.antMatchers("/static/**", "/logout", "/403","/index","/").permitAll()
				.mvcMatchers("/admin").hasRole("administrador")
        		.antMatchers("/admin/**").hasRole("administrador")
				.anyRequest().authenticated()
				.and()
			.formLogin()
				.permitAll()
	            .loginPage("/login")
	            .and()
			.logout()
				.logoutUrl("admin/logout")
				.logoutSuccessUrl("/index")
	            .permitAll();
	}
	
	/*@Bean
	public IwUserDetailsService springDataUserDetailsService() {
		return new IwUserDetailsService();
	}*/
	
 
	//Si eliminas el "Bean" anterior, esto funciona sin BD ni nada:
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) 
			throws Exception {
		auth.inMemoryAuthentication()
				.withUser("admin").password("1234").roles("administrador")
				.and()
				.withUser("paco").password("1234").roles("paciente")
				.and()
				.withUser("juan").password("1234").roles("medico")
				.and()
				.withUser("antonio").password("1234").roles("farmacia");
	}

	
	@Autowired
	private Environment env;
	
    @Bean(name="localData")
    public LocalData getLocalData() {
    	return new LocalData(new File(env.getProperty("es.ucm.fdi.base-path")));
    }    
}