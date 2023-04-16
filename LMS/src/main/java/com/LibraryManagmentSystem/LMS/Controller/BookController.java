package com.LibraryManagmentSystem.LMS.Controller;

import com.LibraryManagmentSystem.LMS.DTO.RequestAuthorDto;
import com.LibraryManagmentSystem.LMS.DTO.RequestBookDto;
import com.LibraryManagmentSystem.LMS.Entity.Book;
import com.LibraryManagmentSystem.LMS.Enum.Genre;
import com.LibraryManagmentSystem.LMS.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Book")
public class BookController {
    @Autowired
    BookService bookService;
    @PostMapping("/add-book")
    public ResponseEntity addBook(@RequestBody RequestBookDto book){
        try{
            bookService.addBook(book);
            return new ResponseEntity<>("book added successfully", HttpStatus.CREATED);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage()+" "+book.getPrice(),HttpStatus.EXPECTATION_FAILED);
        }
    }
    @GetMapping("find-available-books")
    public List<Book> findAllAvailableBook(){
        return bookService.findAllAvailableBook();
    }
    @GetMapping("find-book-by-author")
    public List<Book> findByAuthor(@RequestBody RequestAuthorDto authorDto){
        return bookService.findByAuthor(authorDto);
    }
    @GetMapping("find-by-genre")
    public List<Book> findByGenre(@RequestParam("Genre") Genre genre){
       return bookService.findByGenre(genre);
    }
}
