package com.LibraryManagmentSystem.LMS.Service;

import com.LibraryManagmentSystem.LMS.DTO.RequestAuthorDto;
import com.LibraryManagmentSystem.LMS.Entity.Author;
import com.LibraryManagmentSystem.LMS.Repository.authorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {
        @Autowired
        authorRepo repo;
    public void addAuthor(RequestAuthorDto author){
        Author author1=new Author();
        author1.setName(author.getName());
        author1.setMobile(author.getMobile());
        repo.save(author1);
    }
}
