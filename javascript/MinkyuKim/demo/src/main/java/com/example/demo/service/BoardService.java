package com.example.demo.service;

import com.example.demo.entity.Board;

// Service는 여기서 register가 여러 방식으로 동작할 수 있음을 명시한다.
// 또한 Controller의 Autowired에 자동으로 연결되도록 서포트 한다.

public interface BoardService {
    public void register(Board board) throws Exception;
}