package com.example.authbasic.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                // 실무에서 브라우저 세션 기반 로그인인 경우 켜둠
                .csrf(csrf -> csrf.disable())
                // 인가(권한)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(HttpMethod.GET, "/api/auth").permitAll() // GET으로 들어오는 /api/auth 모두 허용
                        .requestMatchers(HttpMethod.POST,"/api/auth").authenticated () // 로그인을 해야 허용
                        .requestMatchers(HttpMethod.DELETE, "/api/auth/*").hasRole("ADMIN") // ADMIN만 허용
                        .anyRequest().authenticated() // 나머지는 전부 로그인 필요
                )
                // 테스트 방식 Authorization: Basic ...
                .httpBasic(Customizer.withDefaults());

        return http.build();
    }

    // 사용자 정보를 가져오는 서비스
    @Bean
    UserDetailsService userDetailsService(PasswordEncoder encoder) {
        UserDetails user = User.withUsername("user")
                .password(encoder.encode("1234"))
                .roles("USER")
                .build();

        UserDetails admin = User.withUsername("admin")
                .password(encoder.encode("1234"))
                .roles("ADMIN")
                .build();

        // DB가 없어 임시로 메모리에 사용자 2명 등록
        return new InMemoryUserDetailsManager(user,admin);
    }

    @Bean
    PasswordEncoder passwordEncoder() {// 비밀번호 인코딩(복원 불가 형태로 저장)
        return new BCryptPasswordEncoder();
    }
}
