package com.app.config;

import com.app.repository.ContaRepository;
import com.app.service.AutenticaService;
import com.app.service.AutenticaTokenFilter;
import com.app.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AutenticaService AS;
    
    @Autowired
    private TokenService TS;

    @Autowired
    private ContaRepository CR;

    @Autowired
	private SimpleAuthenticationSuccessHandler successHandler;

    @Override
    @Bean
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    //Configuração de Autenticação
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(AS).passwordEncoder(new BCryptPasswordEncoder());
    }
    //Configuração de Autorização
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
        .antMatchers(HttpMethod.GET,"/").permitAll()
        .antMatchers(HttpMethod.GET,"/Login").permitAll()
        .antMatchers(HttpMethod.GET,"/actuator/**").permitAll()
        .antMatchers(HttpMethod.POST,"/Login").permitAll()
        .anyRequest().authenticated()
        .and()
        .formLogin()
        .successHandler(successHandler)
        .loginPage("/Login").and().logout().permitAll();

        // .and().authorizeRequests()
        // .and().csrf().disable()
        // .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        // .and().addFilterBefore(new AutenticaTokenFilter(TS,CR), UsernamePasswordAuthenticationFilter.class);
    }

    //Configuração de recursos estaticos(js,css,imagens,etc.)
    @Override
    public void configure(WebSecurity web) throws Exception {   
        web.ignoring().antMatchers("/css/**","/js/**","/img/**");
    }


}