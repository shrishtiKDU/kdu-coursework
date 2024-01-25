package com.example.demo.repository;
import com.example.demo.exceptions.custom.BadRequestException;
import com.example.demo.exceptions.custom.ResourceNotFoundException;
import com.example.demo.entity.Book;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import com.example.demo.logger.LogBack;
import java.util.List;
@Repository
public class Library {
    private List<Book> booksList = new ArrayList<>();
    public void save(Book book) throws BadRequestException{
        if( book.getBookName()==null || book.getId()==null|| book.getCost()==null){
            LogBack.errorLogger("Error in adding the book!");
            throw new BadRequestException("add fields properly");
        }
         this.booksList.add(book);
        }
    public Book findById(int id) throws ResourceNotFoundException{
    try {
        if (id < 0) {
            LogBack.errorLogger("id provided should be positive");
            throw new ResourceNotFoundException("id must be positive");
        }
        return booksList.get(id);
    }catch (IndexOutOfBoundsException e) {
        LogBack.errorLogger("wrong id provided, No such user found!");
       throw new ResourceNotFoundException("ID incorrect");
    }
    }
    public List<Book> getBooks() throws ResourceNotFoundException{
        if(booksList.isEmpty()){
            LogBack.errorLogger("The list is empty");
            throw new ResourceNotFoundException("the list of books is empty");
        }
        return  booksList;
    }
    public void updateBooks(int id, Book book) throws ResourceNotFoundException{
        try{
            booksList.get(id).setBookName(book.getBookName());
            booksList.get(id).setAuthorName(book.getAuthorName());
            LogBack.infoLogger("updated Successfully");
        }catch (IndexOutOfBoundsException exceptionMessage){
            LogBack.errorLogger("id provided is not founf");
            throw new ResourceNotFoundException("the id provided not found");
        }
    }


    public void deleteById(int id) throws ResourceNotFoundException{
        try {
            booksList.get(id);
        }catch (IndexOutOfBoundsException exceptionMessage){
            LogBack.errorLogger("id provided does not exist");
            throw new ResourceNotFoundException("book not in library");
        }
        booksList.remove(id);
    }

    public Book mostExpensiveBook(){
        Book mostExpensive = booksList.get(0);
        for(int i=1;i<booksList.size();i++){
            Book currentBook = booksList.get(i);
            if(currentBook.getCost() > mostExpensive.getCost()){
                mostExpensive = currentBook;
            }
        }
        return mostExpensive;
    }

    public Book leastExpensiveBook(){
        Book leastExpensive = booksList.get(0);
        for(int i=1;i<booksList.size();i++){
            Book currentBook = booksList.get(i);
            if(currentBook.getCost() > leastExpensive.getCost()){
                leastExpensive = currentBook;
            }
        }
        return leastExpensive;
    }


    public List<Book> getBookByAuthorName(String name) throws ResourceNotFoundException {
        try {
            booksList.stream().anyMatch(book -> book.getAuthorName().equals(name));
        }catch (IndexOutOfBoundsException exceptionMessage){
            throw new ResourceNotFoundException("no author found with the name");
        }
    return booksList.stream().filter(book -> book.getAuthorName().equals(name)).toList();
    }


}
