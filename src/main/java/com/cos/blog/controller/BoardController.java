package com.cos.blog.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.cos.blog.config.auth.PrincipalDetail;

@Controller
public class BoardController {

    @GetMapping({ "", "/" }) // 아무것도 안적었을때, / 일때
    public String index(@AuthenticationPrincipal PrincipalDetail principal) { // 세션 데이터 접근
        // /WEB-INF/views/index.jsp
        // System.out.println("로그인 사용자 아이디: " + principal.getUsername());
        // System.out.println("로그인 사용자 비밀번호: " + principal.getPassword());
        return "index";
    }
}
