package com.example.demo.jswithspring.controller;

import com.example.demo.jswithspring.utility.network.Client;
import com.example.demo.jswithspring.utility.network.Server;
//import com.example.jswithspring.utility.Client;
//import com.example.jswithspring.utility.Server;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class HtmlTestController {
    // HtmlTestController가 제어하는 요소를 디버깅하도록 서포트하는 객체
    // static final Logger log = LoggerFactory.getLogger(HtmlTestController.class);

    @GetMapping("/")
    public String firstIndex() {
        // 위에 Logger 사용하는 방식은 Lombok이 없을 경우 사용함
        // 그래서 이클립스에서는 상당히 불편하게 구성해야하는데 비해
        // 여기서는 맨 위쪽의 @Slf4j 를 추가함으로써
        // 위의 Logger 파트를 적어줄 필요가 없어짐
        log.info("firstIndex() 실행");
        // 여기서 리턴되는 String 값은 resources/templates/htmlHi.html을 의미함
        // 즉 이 부분에 무엇을 배치하냐에 따라 출력되는 내용이 제각각 달라짐을 의미!
        return "htmlHi";
    }

    @GetMapping("/fail")
    public String doFail () {
        log.info("doFail()");

        return "fail";
    }

    @GetMapping("/comparatorTest")
    public String comparatorTest () {
        log.info("comparatorTest()");


        return "test";
    }

    @GetMapping("/serverOn")
    public String startServer () {
        log.info("startServer()");

        Server server = new Server();
        server.waitForClientTest();

        return "test";
    }

    @GetMapping("/clientOn")
    public String startClient () {
        log.info("startClient()");

        Client client = new Client();
        client.connectToServerTest();

        return "test";
    }

}
