package com.example.Reservations.configurations;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.CorsConfigurer;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;


@Configuration
@EnableWebSecurity
//@EnableWebFluxSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    public static final String ADMIN = "admin";
    public static final String USER = "user";

    private final JwtAuthConverter jwtAuthConverter;

    @Bean
    public SecurityFilterChain filterChain (HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                //.cors(CorsConfigurer::disable)
                .authorizeHttpRequests(
                        authorize -> authorize
                                .requestMatchers("/api/v1/reservations/public/**").permitAll()
                                .requestMatchers("/eureka/**").permitAll()
                                .requestMatchers("/swagger/**").permitAll()
                                .anyRequest().authenticated()
                        //.hasRole(ADMIN)
                )
                //.formLogin(Customizer.withDefaults())
                //.oauth2Login(Customizer.withDefaults())
                .sessionManagement(session -> session.sessionCreationPolicy(STATELESS))
                .oauth2ResourceServer((oauth2) -> oauth2
                        .jwt(jwt->jwt.jwtAuthenticationConverter(jwtAuthConverter))
                );
        //.logout(logout -> logout.clearAuthentication(true).invalidateHttpSession(true));
        return http.build();
    }

}
