package com.cos.blog.controller;

import com.cos.blog.service.BoardService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.cos.blog.config.auth.PrincipalDetail;

@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;


    @GetMapping({ "", "/" }) // 아무것도 안적었을때, / 일때
    public String index(Model model, @PageableDefault(size = 2,sort = "id",direction = Sort.Direction.DESC) Pageable pageable) {  //메인페이지로갈때 데이터를 가져가야한다.

        //model은 jsp에서 request정보라고 생각하면된다. 데이터를 파라미터로 담으면 들고 이동.-> index.jsp 의  ${boards}
        model.addAttribute("boards",boardService.글목록(pageable));    // index.jsp로  boards 넘어간다
        return "index";  //@ Controller 는 viewResolver가 작동하는데 해당 인덱스 페이지로 model.의 정보를 들고 이동한다.
        // 또한 뷰리졸버는 리턴값 앞뒤로 application.yml의 prefix,suffix를 붙인다.

    }



    @GetMapping("/board/saveForm")
    public String saveForm() {
        return "board/saveForm";
    }
}
