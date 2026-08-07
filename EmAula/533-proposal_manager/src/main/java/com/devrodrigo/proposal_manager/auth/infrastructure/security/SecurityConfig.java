package com.devrodrigo.proposal_manager.auth.infrastructure.security;

import com.devrodrigo.proposal_manager.auth.domain.UserRole;
import com.devrodrigo.proposal_manager.auth.infrastructure.persistence.entity.User;
import com.devrodrigo.proposal_manager.auth.infrastructure.persistence.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.List;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
    @Bean
    SecurityFilterChain securityFilterChain(
            HttpSecurity http,
            RestUsernamePasswordAuthenticationFilter restUsernamePasswordAuthenticationFilter) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable) // desativa token csrf usado em forms

                .securityContext(context -> context.requireExplicitSave(false)) // ativa cookie entre requisições

                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/auth/login").permitAll()
                        .requestMatchers("/actuator/health").permitAll()
                        .anyRequest().authenticated())
                .addFilterAt(restUsernamePasswordAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

    // removido a adição dos usuário em memória
//    @Bean
//    UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
//        UserDetails influencer = User.withUsername("influencer")
//                .password(passwordEncoder.encode("password"))
//                .roles("INFLUENCER")
//                .build();
//
//        UserDetails brand = User.withUsername("brand")
//                .password(passwordEncoder.encode("password"))
//                .roles("BRAND")
//                .build();
//
//        return new InMemoryUserDetailsManager(influencer, brand);
//    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // se não existir usuários no banco, cria 3 usuários
    @Bean
    CommandLineRunner initDatabase(UserRepository repository, PasswordEncoder passwordEncoder) {
        return args -> {
            if (repository.count() == 0) {
                User fitnessInfluencer = new User();
                fitnessInfluencer.setUsername("fitness_vibe");
                fitnessInfluencer.setPassword(passwordEncoder.encode("password"));
                fitnessInfluencer.setRole(UserRole.INFLUENCER);

                User techInfluencer = new User();
                techInfluencer.setUsername("tech_guru");
                techInfluencer.setPassword(passwordEncoder.encode("password"));
                techInfluencer.setRole(UserRole.INFLUENCER);

                User brand = new User();
                brand.setUsername("logistics");
                brand.setPassword(passwordEncoder.encode("password"));
                brand.setRole(UserRole.BRAND);

                repository.saveAll(List.of(fitnessInfluencer, techInfluencer, brand));
            }
        };
    }

}
