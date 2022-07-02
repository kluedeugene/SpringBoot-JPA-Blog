package com.cos.blog.controller.api;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cos.blog.model.RoleType;
import com.cos.blog.model.User;
import com.cos.blog.service.UserService;
import com.cos.blog.dto.ResponseDto;

@RestController // data만
public class UserApiController {

    @Autowired // @Service로 Bean에 등록되어있다.
    private UserService userService;

    @PostMapping("/auth/joinProc")
    public ResponseDto<Integer> save(@RequestBody User user) { // username,password, email
        System.out.println("UserApiController: save 호출됨");
        // 실제로 db에 insert를하고 아래에서 return이 되야한다.
        user.setRole(RoleType.USER);
        userService.회원가입(user); // 성공=1 실패=0
        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1); // 자바오브젝트를 JSON으로 변환해서 리턴(Jackson이)
    }

}
