package com.cos.blog.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cos.blog.model.RoleType;
import com.cos.blog.model.User;
import com.cos.blog.repository.UserRepository;

@RestController
public class DummyController {
    
        //스프링이 restController 어노테이션을 읽어서, dummyController를 메모리에 띄워줄때. Autowired가 없다면 userrepository는 null이다.
        // 이때 @Autowired를 사용하면 DummyController가 메모리에 뜰때 @Autowired가 메모리에 뜨면서  UserRepository타입으로 스프링이 관리하는 객체가 있다면
        // 스프링이 관리하는 객체를 찾아서 주입해준다.
    @Autowired //의존성 주입이다.(DI)
    private UserRepository userRepository;

    //http://localhost:8000/blog/dummy/join (요청)
    //http 의 body에 username,password, email 데이터를 가지고 (요청)
    @PostMapping("/dummy/join")
    public String join(User user) { // key= value (약속된 규칙)
        
        System.out.println("id: " + user.getId());
        System.out.println("username: " + user.getUsername());
        System.out.println("password: " + user.getPassword());
        System.out.println("email: : " + user.getEmail());
        System.out.println("Role: : " + user.getRole());
        System.out.println("createDate: : " + user.getCreateDate());

        user.setRole(RoleType.USER);
        userRepository.save(user);
        
        return "회원가입이 완료되었습니다.";

    }
}
