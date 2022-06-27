package com.cos.blog.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cos.blog.model.User;
import com.cos.blog.repository.UserRepository;

@Service // 스프링이 컴포넌트 스캔을 통해서 Bean에 등록을 해줌. IoC를 해준다.
public class UserService {

    @Autowired // DI
    private UserRepository userRepository;

    @Transactional // 회원가입 전체의서비스가 하나의 트랜잭션으로 묶인다. 전체가 성공-> 커밋, 실패 -> 롤백
    public int 회원가입(User user) {
        try {
            userRepository.save(user);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("UserService: 회원가입(): " + e.getMessage());
            return -1;
        }
    }
}
