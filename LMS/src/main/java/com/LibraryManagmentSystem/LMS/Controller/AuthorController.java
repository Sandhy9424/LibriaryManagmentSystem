package com.LibraryManagmentSystem.LMS.Controller;

import com.LibraryManagmentSystem.LMS.DTO.RequestAuthorDto;
import com.LibraryManagmentSystem.LMS.Entity.Author;
import com.LibraryManagmentSystem.LMS.Service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Author")
public class AuthorController {
    @Autowired
    AuthorService authorService;
    @PostMapping("/add-author")
    public ResponseEntity addAuthor(@RequestBody RequestAuthorDto author){
        try {
            authorService.addAuthor(author);
            return new ResponseEntity<>("the author is successfully added to the system", HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.EXPECTATION_FAILED);
        }
    }
    @GetMapping("/get-author-by-email")
    public Author findAuthorByMobile(@RequestBody RequestAuthorDto authorDto) throws Exception {
        try{
            Author author=authorService.findByMobile(authorDto);
            return author;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
    @GetMapping("/all-author")
    public List<Author> findAllAuthor(){
        return authorService.allAuthors();
    }
}
