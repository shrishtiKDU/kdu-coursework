package com.example.demo.services;
import com.example.demo.dto.BookDto;
import com.example.demo.entity.Book;
import com.example.demo.exceptions.custom.ResourceNotFoundException;
import com.example.demo.mapper.BookMapper;
import com.example.demo.repository.Library;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookServiceImpl implements BookService {
    private Library library = new Library();
    @Override
    public void addBookToLibrary(BookDto book) {
        Book bookToAdd = BookMapper.mapToBook(book);
        library.save(bookToAdd);
    }
    @Override
    public Book getBookById(int id) throws ResourceNotFoundException {
        return library.findById(id);

    }
    @Override
    public List<Book> getAllBooks() throws ResourceNotFoundException {
        return library.getBooks();
    }
    @Override
    public void updateBook(int id, BookDto book) throws ResourceNotFoundException {
        Book existingBook = library.findById(book.getId());
        existingBook.setId(book.getId());
        existingBook.setBookName(book.getBookName());
        existingBook.setAuthorName(book.getAuthorName());
        existingBook.setCost(book.getCost());
    }
    @Override
    public void deleteBook(int id) throws ResourceNotFoundException {
        library.deleteById(id);
    }
    @Override
    public Book mostExpensiveBook() {
        return library.mostExpensiveBook();
    }
    @Override
    public Book leastExpensive() {
        return library.leastExpensiveBook();
    }
    @Override
       public List<Book> getBookByAuthorName(String authorName) throws ResourceNotFoundException {
      return  library.getBookByAuthorName(authorName);

   }
}