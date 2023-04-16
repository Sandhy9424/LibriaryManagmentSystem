package com.LibraryManagmentSystem.LMS.Controller;

import com.LibraryManagmentSystem.LMS.DTO.RequestBookDto;
import com.LibraryManagmentSystem.LMS.Entity.Book;
import com.LibraryManagmentSystem.LMS.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
