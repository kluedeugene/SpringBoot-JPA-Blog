package com.cos.blog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

//빈등록: 스프링 컨테이너에서 객체를 관리할수있게 하는것.

@Configuration // 빈등록 ioc관리
@EnableWebSecurity // 시큐리티 필터 추가 = 활성화되어잇는 스프링시큐리티의 설정을 해당 파일에서 하겠다.
@EnableGlobalMethodSecurity(prePostEnabled = true) // 특정 주소로 접근을 하면 권한 및 인증을 미리 체크하겠다는 뜻
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
        	.authorizeRequests() // 리퀘스트가 들어오면
                .antMatchers("/auth/**") // ~의 경로들은 permitall. 허용
                .permitAll()
                .anyRequest() // 이게 아닌 모든 요청은
                .authenticated() // 인증이 되야한다.
            .and()
                .formLogin()
                .loginPage("/auth/loginForm");	//인증필요한 경우 해당 경로로
        return http.build();
    }
}
