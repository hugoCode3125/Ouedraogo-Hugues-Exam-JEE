package com.example.backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final JwtFilter jwtFilter;

    public SecurityConfig(JwtFilter jwtFilter) {
        this.jwtFilter = jwtFilter;
    }

    // ================= PASSWORD ENCODER =================
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // ================= IN MEMORY USERS =================
    // Déclarer explicitement le type de retour précis pour éviter les conflits d'interface
    @Bean
    public InMemoryUserDetailsManager userDetailsService() {

        UserDetails client = User.withUsername("client")
                .password(passwordEncoder().encode("1234"))
                .roles("CLIENT")
                .build();

        UserDetails employe = User.withUsername("employe")
                .password(passwordEncoder().encode("1234"))
                .roles("EMPLOYE")
                .build();

        UserDetails admin = User.withUsername("admin")
                .password(passwordEncoder().encode("1234"))
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(client, employe, admin);
    }



    // ================= SECURITY FILTER CHAIN =================
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .cors(cors -> cors.configure(http))
                .authorizeHttpRequests(auth -> auth

                        // Accès libre à l'interface Swagger et OpenAPI Docs
                        .requestMatchers("/swagger-ui/**", "/v3/api-docs/**").permitAll()

                        // Point d'accès de connexion simulé
                        .requestMatchers("/api/auth/**").permitAll()

                        // Règles d'accès strictes pour l'examen
                        .requestMatchers("/api/clients/**").hasAnyRole("EMPLOYE", "ADMIN")
                        .requestMatchers("/api/credits/client/**").hasAnyRole("CLIENT", "EMPLOYE", "ADMIN")
                        .requestMatchers("/api/credits/**").hasAnyRole("EMPLOYE", "ADMIN")
                        .requestMatchers("/api/remboursements/**").hasAnyRole("EMPLOYE", "ADMIN")

                        .anyRequest().authenticated()
                )
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}