package com.example.testboard.service;

import com.example.testboard.entity.Board;
import com.example.testboard.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {

    private final BoardMapper boardMapper;

    @Autowired
    public BoardService(BoardMapper boardMapper) {
        this.boardMapper = boardMapper;
    }

    public List<Board> getBoards() {
        return boardMapper.getBoards();
    }

    public Board getBoard(int boardNo) {
        return boardMapper.getBoard(boardNo);
    }

    public void registerBoard(String title, String content, int category) {
        boardMapper.registerBoard(title, content, category);
    }
}
