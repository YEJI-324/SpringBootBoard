package com.example.testboard.mapper;

import com.example.testboard.entity.Board;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BoardMapper {

    List<Board> getBoards();

    Board getBoard(int boardNo);

    void registerBoard(String title, String content, int category);
}
