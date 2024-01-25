package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
    @Data
    @AllArgsConstructor
    public class BookDto {
        private  Integer id;
        private String bookName;
        private String authorName;
        private Integer cost;
}
