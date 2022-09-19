package com.example.testboard.controller;

import com.example.testboard.entity.Board;
import com.example.testboard.service.BoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Slf4j
@RestController
@RequestMapping("/api/board")
public class BoardController {

    private final BoardService boardService;
//    private final BoardRepository boardRepository;

    @Autowired
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    // 조회
    @RequestMapping(value = "/{boardNo}", method = RequestMethod.GET)
    public Object ReadAll(@PathVariable("boardNo") int boardNo) {
        if (boardNo != 0) {
            // 상세 조회
            return boardService.getBoardDetail(boardNo);
        } else {
            // 전체 조회
            // TODO: 2022-09-19 페이징 처리 필요
            return boardService.getAllBoard();
        }
    }

    // 추가
    // TODO: 2022-09-19 form data로 변경 필요
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public void registerBoard(Board board) {
//        return board;
    }

    // 수정
    // TODO: 2022-09-19 form data로 변경 필요
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
