package com.cos.blog.controller.api;

import com.cos.blog.config.auth.PrincipalDetail;
import com.cos.blog.dto.ResponseDto;
import com.cos.blog.model.User;
import com.cos.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController // data만
public class UserApiController {

    @Autowired // @Service로 Bean에 등록되어있다.
    private UserService userService;

    @Autowired
    private org.springframework.security.authentication.AuthenticationManager AuthenticationManager;


    @PostMapping("/auth/joinProc")
    public ResponseDto<Integer> save(@RequestBody User user) { // username,password, email
        System.out.println("UserApiController: save 호출됨");

        userService.회원가입(user); // 성공=1 실패=0
        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1); // 자바오브젝트를 JSON으로 변환해서 리턴(Jackson이)
    }

    @PutMapping("/user")
    public ResponseDto<Integer> update(@RequestBody User user) {         //RequestBody 가없으면 json을 못받음 . key value 형태만 받을수있음(x-www-form-urlencoded)
        userService.회원수정(user);
        //여기서는 트랜잭션이 종료되어서 DB의값은 변경되었지만
        //세션값이 변경되지 않은 상태기 때문에 변경후 다시조회하면 VLAUE값이 업데이트가 안되어있다.(로그아웃하고 다시 확인해야한다.)
        //직접 세션값을 변경해주어야한다.

        //세션등록  (회원정보 수정 후 세션 업데이트 하기위한) 서비스단에서는 아직 commit된 상태가아니기때문에 세션을 새로고침할수없다. 고로 컨트롤러단인 여기서
        Authentication authentication = AuthenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);


        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }

}
