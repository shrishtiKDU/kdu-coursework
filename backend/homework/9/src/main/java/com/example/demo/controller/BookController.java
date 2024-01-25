package com.example.demo.controller;
import com.example.demo.dto.BookDto;
import com.example.demo.entity.Book;
import com.example.demo.exceptions.custom.ResourceNotFoundException;
import com.example.demo.services.BookService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import com.example.demo.logger.LogBack;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@AllArgsConstructor
public class BookController {

    private BookService bookService;

    @PostMapping("/api/book")
    public ResponseEntity<String>addBook(@RequestBody BookDto bookDto){
        bookService.addBookToLibrary(bookDto);
        String message = "success to add the book";
        LogBack.infoLogger(message);
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }
    @GetMapping("/api/book")
    public Book getBookById(@RequestParam("id") int id) throws ResourceNotFoundException {
        LogBack.infoLogger("fetching the books:");
        return bookService.getBookById(id);
    }
    @GetMapping("/api/book/allBook")
    public ResponseEntity<List<Book>> getAllBooks() throws ResourceNotFoundException {
        LogBack.infoLogger("getALlBooks");
        List<Book> books = bookService.getAllBooks();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }
    @PutMapping("/api/book/update")
    public ResponseEntity<String> updateBook(@RequestParam(name="id") int id, @RequestBody BookDto book) throws ResourceNotFoundException {
        bookService.updateBook(id,book);
        String message = "update success";
        LogBack.infoLogger("updates book");
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
    @DeleteMapping("/api/book/delete")
    public ResponseEntity<String> deleteBook(@RequestParam(name="id") int id) throws ResourceNotFoundException {
        bookService.deleteBook(id);
        String message =  "delete successful";
        LogBack.infoLogger("deletion successful");
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
    @GetMapping("/api/book/mostExpensive")
    public Book mostExpensive(){
        return bookService.mostExpensiveBook();
    }
    @GetMapping("/api/book/leastExpensive")
    public Book leastExpensive(){
        return bookService.leastExpensive();
    }

}
