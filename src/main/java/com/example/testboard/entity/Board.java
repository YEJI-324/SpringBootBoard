package com.example.testboard.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Board {

    private int id;
    private String title;
    private String content;
    private int category;
    private int cnt;
    private String regDate;
    private String modDate;
}
