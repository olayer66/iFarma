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
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
        		.antMatchers("/static/**", "/logout", "/403","/index","/","/mm",
        				"/estadoDenegado",
        				"/avisoLegal",
        				"/nuevoFarmaceutico",
        				"/nuevoMedico",
        				"/validarPaciente",
        				"/nuevoFarmaceuticoSubmit",
        				"/nuevoMedicoSubmit",
        				"/validarPacienteSubmit",
        				"/validarCodigo").permitAll()
				.mvcMatchers("/admin").hasRole("ADMIN")
        		.antMatchers("/admin/**").hasRole("ADMIN")
        		.mvcMatchers("/medico").hasRole("MED")
        		.antMatchers("/medico/**").hasRole("MED")
        		.mvcMatchers("/paciente").hasRole("PAC")
        		.antMatchers("/paciente/**").hasRole("PAC")
        		.mvcMatchers("/farmacia").hasRole("FAR")
        		.antMatchers("/farmacia/**").hasRole("FAR")
				.anyRequest().authenticated()
				.and()
			.formLogin()
				.permitAll()
	            .loginPage("/login")
	            .usernameParameter("ssoId").passwordParameter("password")
	            .successHandler(new AuthSuccessHandler())
	            .and().csrf()
	            .and().exceptionHandling().accessDeniedPage("/denegado")
	            .and()
			.logout()
				.logoutUrl("admin/logout")
				.logoutSuccessUrl("/index")
				.deleteCookies("usuario")
	            .permitAll();
	}
	
	@Bean
	public IwUserDetailsService springDataUserDetailsService() {
		return new IwUserDetailsService();
	}
	
	//contraseñas cifradas
	@Bean
	public PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}
	
	
	/*//Si eliminas el "Bean" anterior, esto funciona sin BD ni nada:
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) 
			throws Exception {
		auth.inMemoryAuthentication()
				.withUser("admin").password("1234").roles("ADMIN")
				.and()
				.withUser("paco").password("1234").roles("PAC")
				.and()
				.withUser("juan").password("1234").roles("MED")
				.and()
				.withUser("antonio").password("1234").roles("FAR");
	}
*/
	
	@Autowired
	private Environment env;
	
    @Bean(name="localData")
    public LocalData getLocalData() {
    	return new LocalData(new File(env.getProperty("es.ucm.fdi.base-path")));
    } 
}