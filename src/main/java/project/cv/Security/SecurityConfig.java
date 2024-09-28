package project.cv.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true) // @PreAuthorize annotations enabled
public class SecurityConfig {

    @Bean
    protected InMemoryUserDetailsManager userDetailsManager() {
        UserDetails salih = User.builder()
                .username("salih")
                .password("{noop}test123")
                .roles("EMPLOYEE")
                .build();
        UserDetails hamza = User.builder()
                .username("hamza")
                .password("{noop}test1234")
                .roles("EMPLOYEE", "MANAGER")
                .build();
        UserDetails admin = User.builder()
                .username("Admin")
                .password("{noop}test12345")
                .roles("EMPLOYEE", "MANAGER", "ADMIN")
                .build();

        return new InMemoryUserDetailsManager(salih, hamza, admin);
    }

    @Bean
    protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authz -> authz
                        .requestMatchers("/", "/index.html", "/index/**", "/login/**", "/admin/pages/**").permitAll() // Public paths
                        .requestMatchers("/downloadPdf/**").permitAll() // Allow PDF download endpoint
                        .requestMatchers("/admin/**").hasRole("ADMIN") // ADMIN role access only
                        .requestMatchers("/files/download/**").permitAll()
                        .requestMatchers("/forum").permitAll()
                        .anyRequest().authenticated() // Other paths require authentication
                )
                .formLogin(form -> form
                        .loginPage("/login")
                        .loginProcessingUrl("/actionLogin")
                        .defaultSuccessUrl("/", true) // Redirect to home after successful login
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/login?logout") // Redirect to login after logout
                        .permitAll()
                )
                .exceptionHandling(exceptionHandling -> exceptionHandling
                        .accessDeniedPage("/access-denied") // Custom error page for access denied
                )
                .csrf((csrf) -> csrf.disable()); // Disable CSRF for simplicity (ensure it matches your app needs) // Disable CSRF for simplicity (ensure it matches your app needs)

        return http.build();
    }
}
