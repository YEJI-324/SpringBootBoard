package com.example.testboard.controller;

import com.example.testboard.entity.Board;
import com.example.testboard.service.BoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@RequestMapping("/api/board")
public class BoardController {

    private final BoardService boardService;

    @Autowired
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    // 조회
    @RequestMapping(value = "/{boardNo}", method = RequestMethod.GET)
    public Object ReadAll(@PathVariable("boardNo") int boardNo) {
        if (boardNo != 0) {
            // 상세 조회
            return boardService.getBoard(boardNo);
        } else {
            // 전체 조회
            return boardService.getBoards();
        }
    }

    // 추가
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerBoard(String title, String content, int category) {
        System.out.println("Reqeust\ntitle : " + title + "content : " + content + "category : " + category);
        boardService.registerBoard(title, content, category);
        return "Success";
    }

    // 수정
    @RequestMapping(value = "/modify", method = RequestMethod.PUT)
    public Board modifyBoard(Board board) {
        return board;
    }

    // 삭제
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public void deleteBoard() {
        log.info("delete board");
    }
}
