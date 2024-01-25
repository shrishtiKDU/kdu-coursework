package com.example.demo.mapper;
import com.example.demo.dto.BookDto;
import com.example.demo.entity.Book;
public class BookMapper {
    public static BookDto mapToBookDto(Book book){
        return  new BookDto(
               book.getId(),
               book.getBookName(),
               book.getAuthorName(),
               book.getCost()

        );
    }
    public static Book mapToBook(BookDto bookDto){
        return new Book(
                bookDto.getId(),
                bookDto.getBookName(),
                bookDto.getAuthorName(),
                bookDto.getCost());
    }
}

