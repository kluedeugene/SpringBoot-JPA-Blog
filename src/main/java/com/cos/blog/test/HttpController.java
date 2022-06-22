package com.cos.blog.test;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//사용자가 요청-> 응답(html 파일) -> @Controller

//사용자가 요청-> 응답(data) -> @RestController
@RestController
public class HttpController {

    private static final String TAG = "HttpController: ";

    @GetMapping("/http/lombok")
    public String lombokTest() {
        // Member m = new Member(1, "test", "1234", "email");
        // builder를 이용해서 생성자를 자동으로 생성해줌
        // lombok-builder를쓰면 장점은 추후에 데이터 삽입시 순서를 지키지않아도 된다. 순서 실수가 발생하지않는다.
        Member m = Member.builder().id(1).username("test").password("1234").email("email").build();
        System.out.println(TAG + "getter: " + m.getUsername());
        m.setUsername("username");
        System.out.println(TAG + "setter: " + m.getUsername());
        return "lombokTest 완료";
    }

    // 인터넷 브라우저 요청은 무조건 get요청밖에 할수없다.
    // http://localhost:8080/http/get (select)
    @GetMapping("/http/get")
    public String getTest(Member m) {

        return "get 요청: " + m.getId() + ", " + m.getUsername() + ", " + m.getPassword() + ", " + m.getEmail();
    }

    // http://localhost:8080/http/post (insert)
    @PostMapping("/http/post") // text/plain , application/json
    public String postTest(@RequestBody Member m) { // MessageConverter (스프링부트)
        return "post 요청: " + m.getId() + ", " + m.getUsername() + ", " + m.getPassword() + ", " + m.getEmail();

    }

    // http://localhost:8080/http/put (update)
    @PutMapping("/http/put")
    public String putTest(@RequestBody Member m) {
        return "put 요청: " + m.getId() + ", " + m.getUsername() + ", " + m.getPassword() + ", " + m.getEmail();
    }

    // http://localhost:8080/http/delete (delete)
    @DeleteMapping("/http/delete")
    public String deleteTest() {
        return "delete 요청";
    }

}
