package com.cos.blog.test;

import java.util.Optional;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cos.blog.model.RoleType;
import com.cos.blog.model.User;
import com.cos.blog.repository.UserRepository;

//html파일이 아니라 data를 반환하는 컨트롤러 = RestController
@RestController
public class DummyController {
    
        //스프링이 restController 어노테이션을 읽어서, dummyController를 메모리에 띄워줄때. Autowired가 없다면 userrepository는 null이다.
        // 이때 @Autowired를 사용하면 DummyController가 메모리에 뜰때 @Autowired가 메모리에 뜨면서  UserRepository타입으로 스프링이 관리하는 객체가 있다면
        // 스프링이 관리하는 객체를 찾아서 주입해준다.
    @Autowired //의존성 주입이다.(DI)
    private UserRepository userRepository;

    // {id} 주소로 파라미터를 전달 받을수있음
    // http://localhost:8000/blog/dummy/user/{id}
    @GetMapping("/dummy/user/{id}")
    public User datail(@PathVariable int id) {
        //user/{id} 를 찾는데 데이터베이스에 못찾는다면 user가 null이된다. 
        //그럼 return null 이 되어서 에러가 발생할수있다.
        //optional로 User객체를 감싸서 가져오고, null 인지 아닌지 판단해서 return

        //람다식
        // User user=userRepository.findById(id).orElseThrow(()->{
        //     return new IllegalArgumentException("없는 유저입니다.");
        // });
        

       User user = userRepository.findById(id).orElseThrow(new Supplier<IllegalArgumentException>() {
        @Override
        public IllegalArgumentException get() {
            return new IllegalArgumentException("없는 사용자입니다. id:"+id);
        }
       });

       //요청=웹브라우저
       //user 객체 =자바 오브젝트 -> 브라우저가 이해하지못한다. 
       //변환( 웹브라우저가 이해할수있는 데이터)-> JSon(Gson 라이브러리)
       // 스프링부트= MessageConverter라는 애가 응답시에 자동 작동
       //만약에 자바 오브젝트를 리턴하게되면 Messageconverter가 Jackson을 호출해서 
       //user 오브젝트를 json 으로 변환해서 브라우저에게 던져줍니다.
        return  user;
    }

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