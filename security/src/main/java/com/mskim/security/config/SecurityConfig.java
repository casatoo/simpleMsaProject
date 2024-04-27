package com.mskim.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{

        http
                .authorizeHttpRequests((auth) -> auth
                        .requestMatchers("/", "/security/login", "/security/join", "/security/loginProc","/security/joinProc").permitAll() // 해당 경로는 모든 접근 가능
                        .requestMatchers("/security/admin").hasRole("ADMIN") // ADMIN 권한만 접근 가능
                        .requestMatchers("/my/**").hasAnyRole("ADMIN","USER") // ** 와일드카드 적용 , ADMIN, USER 접근 가능
                        //.requestMatchers("/deny").denyAll() // 모든권한 접근 제한
                        .anyRequest().authenticated() // 나머지 모든 경로 - 모든 로그인 사용자 접근 가능
                );

        http
                .formLogin((auth) -> auth.loginPage("/security/login") // 자동으로 로그인 페이지로 이동
                        .loginProcessingUrl("/security/loginProc") // 로그인 데이터를 넘겨 로그인처리를 진행
                        .permitAll()
                );

        http
                .csrf((auth) -> auth.disable()); // 위변조 방지를 위한 설정 임시 disable 처리

        return http.build();
    }

}
