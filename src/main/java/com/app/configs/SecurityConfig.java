package com.app.configs;

import com.app.services.AutenticaService;

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
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AutenticaService AS;
    
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    @Bean
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    // Configuração de Autenticação
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(AS).passwordEncoder(new BCryptPasswordEncoder());
    }

    // Configuração de recursos estaticos(js,css,imagens,etc.)
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/css/**", "/js/**", "/img/**");
    }

    // Configuração de Autorização
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
        .antMatchers(HttpMethod.GET,"/").permitAll()
        .antMatchers(HttpMethod.GET,"/Login").permitAll()
        .antMatchers(HttpMethod.POST,"/Login").permitAll()
        .antMatchers(HttpMethod.GET,"/Register").permitAll()
        .antMatchers(HttpMethod.POST,"/Register").permitAll()
        .antMatchers(HttpMethod.GET,"/actuator/**").permitAll()
        .anyRequest().authenticated()
        .and()
        .formLogin().loginPage("/Login")
        .permitAll()
        .and()
        .logout()
        .permitAll();
    }

}