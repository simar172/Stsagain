package com.example.demo;

import com.example.demo.CustomuserdetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class Config extends WebSecurityConfigurerAdapter {
    @Autowired
    CustomuserdetailService cs;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // TODO Auto-generated method stub
        http.authorizeRequests().antMatchers("/login","/signup/**").permitAll().antMatchers("/public/**").hasRole("NORMAL")
                .antMatchers("/users/**").hasRole("ADMIN").anyRequest().authenticated().and().rememberMe().key("simar")
                .rememberMeParameter("remember").rememberMeCookieName("remeberlog").tokenValiditySeconds(100).and()
                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).and().formLogin()
                .loginPage("/login").loginProcessingUrl("/submit");
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/css/**","/images/**","/js/**");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // TODO Auto-generated method stub
        auth.userDetailsService(cs).passwordEncoder(encode());
    }

    @Bean
    public BCryptPasswordEncoder encode() {
        return new BCryptPasswordEncoder(10);
    }

}
