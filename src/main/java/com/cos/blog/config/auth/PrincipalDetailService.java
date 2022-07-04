package com.cos.blog.config.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cos.blog.model.User;
import com.cos.blog.repository.UserRepository;

@Service // bean 등록
public class PrincipalDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    // 스프링이 로그인 요청가로챌때, username, password 변수 2개를 가로채는데,
    // password 부분처리는 알아서 되지만, username은 DB에 있는지만 확인해주면 된다.
    // 아래와같이 오버라이딩하여 구현하지않으면 우리가 들고있는 유저정보를 담아줄수가 없다.
    // ↳ ( 기본 시큐리티 구성되었을때 콘솔에 뜨는 아이디 user 패스워드 ~~~로만 기본 구성이 된다.)
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User principal = userRepository.findByUsername(username)
                .orElseThrow(() -> {
                    return new UsernameNotFoundException("해당 사용자를 찾을수 없습니다.:" + username);
                });
        return new PrincipalDetail(principal); // User타입을 반환할수는 없으니 principaldetail로 , // 시큐리티 세션에 유저 정보가 저장이 된다.
    }

}
