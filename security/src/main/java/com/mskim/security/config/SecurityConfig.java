package com.mskim.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
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
//                .formLogin((auth) -> auth // formLogin 방식 구현
//                        .loginPage("/security/login") // 자동으로 로그인 페이지로 이동
//                        .loginProcessingUrl("/security/loginProc") // 로그인 데이터를 넘겨 로그인처리를 진행
//                        .permitAll()
//                );
                .httpBasic(Customizer.withDefaults()); // http basic 방식 로그인 구현

        http    // csrf 설정 시 로그아웃 요청을 post 로 해야하지만 get 방식으로 요청 시 해당 설정이 필요 함, logoutController 설정도 필요
                .logout((auth) -> auth.logoutUrl("/security/logout")
                        .logoutSuccessUrl("/"));

//        http    // Cross-Site Request Forgery
//                .csrf((auth) -> auth.disable()); // 위변조 방지를 위한 설정, 임시 disable 처리

        http
                .sessionManagement((auth) -> auth
                        .maximumSessions(1) // 하나의 아이디에 대한 다중로그인 허용 갯수
                        .maxSessionsPreventsLogin(true)); // 다중로그인 갯수를 초과했을 때 처리 true : 새로운로그인 차단 , false : 기존 세션 하나 삭제

        http
                .sessionManagement((auth) -> auth
                        .sessionFixation() // 세션 고정 공격을 방어하기 위한
                        //.none()); // 로그인 시 세션 정보 변경 안함
                        //.newSession()); // 로그인 시 세션 새로 생성
                        .changeSessionId()); // 로그인 시 동일 세션에 대한 id 변경

        return http.build();
    }
//      데이터베이스로 사용자 정보를 사용하지 않고 소수의 사용자를 등록하여 사용할 때
//    @Bean
//    public UserDetailsService userDetailsService() {
//
//        UserDetails user1 = User.builder()
//                .username("user1")
//                .password(bCryptPasswordEncoder().encode("1234"))
//                .roles("ADMIN")
//                .build();
//
//        UserDetails user2 = User.builder()
//                .username("user2")
//                .password(bCryptPasswordEncoder().encode("1234"))
//                .roles("USER")
//                .build();
//
//        return new InMemoryUserDetailsManager(user1,user2);
//    }

}
