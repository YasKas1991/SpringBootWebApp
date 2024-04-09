package com.example.application.security;


import com.example.application.views.list.LoginView;
import com.vaadin.flow.spring.security.VaadinWebSecurity;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends VaadinWebSecurity {

    @Override
    protected void configure(HttpSecurity http) throws Exception {  //Security config Vaadin
        super.configure(http);
        setLoginView(http, LoginView.class); //setting customer login view
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().requestMatchers("/images/**"); // Ignore image folder
        super.configure(web);
    }
    @Bean
    protected UserDetailsService userDetailsService(){
        return new InMemoryUserDetailsManager(User.withUsername("user")
                .password("{noop}userpass")
                .roles("USER")
                .build()); //Must use a proper authenticator*
   }
}
