package com.cos.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.blog.model.RoleType;
import com.cos.blog.model.User;
import com.cos.blog.repository.UserRepository;

@Service // 스프링이 컴포넌트 스캔을 통해서 Bean에 등록을 해줌. IoC를 해준다.
public class UserService {

    @Autowired // DI
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder encoder;  //암호화


    @Transactional // 회원가입 전체의서비스가 하나의 트랜잭션으로 묶인다. 전체가 성공-> 커밋, 실패 -> 롤백
    public void 회원가입(User user) {

        String rawPassword = user.getPassword(); // 비밀번호 원문
        String encPassword = encoder.encode(rawPassword); // 해쉬화
        user.setPassword(encPassword);
        user.setRole(RoleType.USER);
        userRepository.save(user);
    }

    @Transactional
    public void 회원수정(User user) {
        //수정시에는 영속성컨텍스트에 유저오브젝트를 영속화시키고, 영속화된 유저오브젝트를 수정.
        //select를 해서 유저오브젝트를 DB로부터 가져오는 이유는 영속화 하기위해서 !!
        //영속화된 오브젝트를 변경하면 자동으로 DB에 업데이트문을 날려준다.

        User persistance = userRepository.findById(user.getId()).orElseThrow(() -> {
            return new IllegalArgumentException("회원찾기 실패");
        });

        String rawPassword = user.getPassword(); // 비밀번호 원문
        String encPassword = encoder.encode(rawPassword); // 해쉬화
        persistance.setPassword(encPassword);
        persistance.setEmail(user.getEmail());


        //회원수정 함수 종료시 = 서비스 종료 = 트랜잭션 종료 = commit이 자동으로 된다.
        //영속화된 persistance 객체의 변화가 감지되면 더티체킹이되어 update문을 날려줌.
    }

    // @Transactional(readOnly = true) // select할때 트랜젝션 시작, 서비스 종료시에 트랜젝션 종료( 정합성 )
    // public User 로그인(User user) {// 여기선 select를 한번만 하지만 여러번하더라도 같은데이터를
    // 찾을수있도록하는것.(정합성)
    // return userRepository.findByUsernameAndPassword(user.getUsername(),
    // user.getPassword());
    // }
}
