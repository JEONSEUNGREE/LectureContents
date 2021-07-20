package com.example.demo.controller.vue;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class Controller0630Vue {
    @GetMapping("/vueIndex")
    public String getVueIndex(){
        log.info("getVueIndex");

        return "/vue/Review0630/index";
    }

}




















