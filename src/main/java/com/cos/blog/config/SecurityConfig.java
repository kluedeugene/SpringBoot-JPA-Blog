package com.cos.blog.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.cos.blog.config.auth.PrincipalDetailService;

//빈등록: 스프링 컨테이너에서 객체를 관리할수있게 하는것.

@Configuration // 빈등록 ioc관리
@EnableWebSecurity // 시큐리티 필터 추가 = 활성화되어잇는 스프링시큐리티의 설정을 해당 파일에서 하겠다.
@EnableGlobalMethodSecurity(prePostEnabled = true) // 특정 주소로 접근을 하면 권한 및 인증을 미리 체크하겠다는 뜻
public class SecurityConfig {

    // @Autowired
    // private PrincipalDetailService principalDetailService;

    @Bean // Ioc가 되어 스프링에 등록
    public BCryptPasswordEncoder encodePWD() {
        return new BCryptPasswordEncoder();
    }

    // 시큐리티가 대신 로그인하는데 password를 가로채기를 하는데
    // 해당 password가 뭘로 해시가 되어 회원가입이 되었는지 알아야
    // 같은 해시로 암호화해서 DB에 있는 해쉬랑 비교할 수 있음.
    // @Override
    // protected void configure(AuthenticationManagerBuilder auth) throws Exception
    // {
    // auth.userDetailsService(principalDetailService).passwordEncoder(encodePWD());
    // }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                // csrf 토큰 비활성화 , 스프링 시큐리티는 CSRF토큰이 없으면 차단한다.
                // 데이터를 AJAX를 통해 자바스크립트로 요청이 들어오면 토큰이없다.(추후에 추가)
                .csrf().disable()
                .authorizeRequests() // 리퀘스트가 들어오면
                .antMatchers("/", "/auth/**", "/js/**", "/css/**", "/image/**") // ~의 경로들은 permitall. 허용
                .permitAll()
                .anyRequest() // 위에 허용된 요청이 아닌 모든 요청은 밑의 로그인폼으로 간다.
                .authenticated() // 인증이 되야한다.
                .and()
                .formLogin()
                .loginPage("/auth/loginForm") // 인증필요한 경우 해당 경로로
                .loginProcessingUrl("/auth/loginProc") // 스프링 시큐리티가 해당 주소로 요청오는 로그인을 가로채서 대신로그인한다.
                .defaultSuccessUrl("/"); // 정상적으로 로그인이 끝나면 해당 주소로 이동.
        return http.build();
    }
}
