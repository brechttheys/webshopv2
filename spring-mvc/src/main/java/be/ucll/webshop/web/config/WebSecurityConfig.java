package be.ucll.webshop.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();

        manager.createUser(User.withDefaultPasswordEncoder().username("brecht").password("1234").roles("USER").build());
        manager.createUser(User.withDefaultPasswordEncoder().username("admin").password("t").roles("ADMIN").build());
        return manager;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().ignoringAntMatchers("/rest/**");
        http.csrf().disable().authorizeRequests()
                .antMatchers("/", "/index.htm").permitAll()
                .antMatchers("/css/**", "/images/**").permitAll()
                .antMatchers("/product.htm").hasAnyRole("USER","ADMIN")
                .antMatchers("/product/**").hasRole("ADMIN")
                .antMatchers("/rest/products.htm").permitAll()
                .antMatchers("/rest/products/**").permitAll()
                .antMatchers("/weather.htm").permitAll()
                .antMatchers("/user.htm").permitAll()
                .antMatchers("/user/**").permitAll()
                .antMatchers("/basket.htm").permitAll()
                .antMatchers("/basket/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .defaultSuccessUrl("/")
                .and()
                .httpBasic();
    }

}
