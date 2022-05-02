package com.senac.ac.config;

import com.senac.ac.service.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private CustomUserDetails customUserDetails;

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.csrf().disable().authorizeRequests()
                .antMatchers(HttpMethod.GET, "/automation/v1/api").permitAll()
                .antMatchers(HttpMethod.GET, "/swagger-ui.html#/").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();

//       .and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"));

    }
//    //Authentication INMEMORY
//    @Autowired
//    protected void	configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("bruno").password(encoder.encode("1234")).roles("USER","ADMIN")
//                .and()
//                .withUser("bob").password(encoder.encode("user")).roles("USER");
//    }

    //Authentication DATA_BASED BACKED
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(customUserDetails).passwordEncoder(new BCryptPasswordEncoder());
    }

}
