package com.cos.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.blog.model.User;
import com.cos.blog.repository.UserRepository;

@Service // 스프링이 컴포넌트 스캔을 통해서 Bean에 등록을 해줌. IoC를 해준다.
public class UserService {

    @Autowired // DI
    private UserRepository userRepository;

    @Transactional // 회원가입 전체의서비스가 하나의 트랜잭션으로 묶인다. 전체가 성공-> 커밋, 실패 -> 롤백
    public void 회원가입(User user) {
        userRepository.save(user);
    }

    @Transactional(readOnly = true) // select할때 트랜젝션 시작, 서비스 종료시에 트랜젝션 종료( 정합성 )
    public User 로그인(User user) {// 여기선 select를 한번만 하지만 여러번하더라도 같은데이터를 찾을수있도록하는것.(정합성)
        return userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
    }
}
