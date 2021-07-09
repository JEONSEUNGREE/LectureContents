package com.example.cholongtest.controller.board;


import com.example.cholongtest.service.BoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Slf4j
@Controller
public class SeventhController {

    @Autowired
    private BoardService service;

    @GetMapping("/read")
    public String getRead(int boardNo, Model model) throws Exception {
        log.info("read");

        // read가 리턴하는 결과가 무엇인가 ? Board 객체(Board 클래스의 메모리 적재 상태)
        // 클래스는 앞 시작 및 이니셜이 대문자
        // 클래스가 아닌 일반 변수들(객체 포함)
        // 앞 시작이 소문자가 이니셜은 대문자임 <<<<-----
        // SignUp ---> signUp

        model.addAttribute(service.read(boardNo));

        return "board/seventh/read";

    }

    // 글을 지워도 숫자가 올라가야만 하는 이유가 무엇인가 ?
    // 배열 100개에서 중간의 값을 지우는 경우
    // = 값을 땡겨오지 않음.

    @PostMapping("/remove")
    public String remove (int boardNo, Model model) throws Exception {
        log.info("remove");

        service.remove(boardNo);
        model.addAttribute("msg", "삭제가 완료되었습니다!");

        return "board/fourth/success";
    }
}
