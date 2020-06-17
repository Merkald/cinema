package cinema.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder);
    }

    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/register", "/inject", "/login")
                .permitAll()
                .antMatchers(HttpMethod.POST,"/orders/complete", "/shopping-carts/**")
                .hasRole("USER")
                .antMatchers(HttpMethod.POST, "/cinema-halls/**", "/movies/**",
                        "/movie-sessions/**")
                .hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/users/by-email", "/movies",
                        "/cinema-halls", "/shopping-carts", "/movie-sessions/available", "/orders")
                .hasAnyRole("USER", "ADMIN")
                .anyRequest()
                .authenticated()
                .and().formLogin().permitAll()
                .and().logout()
                .and().httpBasic()
                .and().csrf().disable();
    }
}
