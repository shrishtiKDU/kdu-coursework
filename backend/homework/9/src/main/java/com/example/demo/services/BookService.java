package com.example.demo.services;


import com.example.demo.dto.BookDto;
import com.example.demo.exceptions.custom.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Book;
import java.util.List;

@Service
public interface BookService {

    void addBookToLibrary(BookDto book);
    Book getBookById(int id) throws ResourceNotFoundException;

    List<Book> getAllBooks() throws ResourceNotFoundException;

    void updateBook(int id, BookDto book) throws ResourceNotFoundException;

    void deleteBook(int id) throws ResourceNotFoundException;

    Book mostExpensiveBook();
    Book leastExpensive();

    List<Book> getBookByAuthorName(String authorName) throws ResourceNotFoundException;
}
