package com.ghostcoderz.vedveeracoaching.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * This class is used to configure the Spring Security for the application
 * <br>
 * @author Ved Asole
 */
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final MyUserDetailsService userDetailsService;

    public SecurityConfiguration(MyUserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()

                // Configuring url access
                .antMatchers("/").permitAll()
                .antMatchers("/h2-console/*").hasRole("ADMIN")
                .antMatchers("/admin").hasRole("ADMIN")
                .antMatchers("/user").hasRole("USER")
                .and().

                // Configuring the Form Login
                formLogin().loginPage("/login")
                .usernameParameter("username")
                .passwordParameter("password")
                .defaultSuccessUrl("/dashboard", true)
                .failureUrl("/login/error")

                // Configuring the Logout Functionality
                .and().logout().logoutUrl("/logout")
                .logoutSuccessUrl("/")

                // Disable CSRF
                .and().csrf().disable()

                // Disable Frame Headers for H2-Console
                .headers().frameOptions().disable();

    }

    @Bean
    public static PasswordEncoder getPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
