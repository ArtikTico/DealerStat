package by.stankevich.artemiy.finalproject.dealerstat.configuration;

import by.stankevich.artemiy.finalproject.dealerstat.entity.UserRole;
import by.stankevich.artemiy.finalproject.dealerstat.security.Jwt.JwtConfigurer;
import by.stankevich.artemiy.finalproject.dealerstat.security.Jwt.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private static final String ADMIN_ENDPOINTS = "/**";
    private static final String LOGIN_ENDPOINT = "api/auth/**";
    private static final String REGISTRATION_ENDPOINTS = "/api/registration";

    private final JwtTokenProvider jwtTokenProvider;

    @Autowired
    public SecurityConfiguration(JwtTokenProvider jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                    .csrf().and().cors().disable()
                    .httpBasic().disable()
                    .sessionManagement()
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                    .antMatchers("/").permitAll()
                    .antMatchers(ADMIN_ENDPOINTS).hasRole(UserRole.ADMIN.name())
                    .antMatchers(LOGIN_ENDPOINT).permitAll()
                    .antMatchers(REGISTRATION_ENDPOINTS).permitAll()
                .anyRequest().authenticated()
                .and()
                .apply(new JwtConfigurer(jwtTokenProvider));
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

}
