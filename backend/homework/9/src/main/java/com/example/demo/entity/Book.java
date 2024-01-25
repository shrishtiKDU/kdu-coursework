package com.example.demo.entity;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Book {
    private Integer id;
    private String bookName;
    private String authorName;
    private Integer cost;

}
