package com.LibraryManagmentSystem.LMS.Service;

import com.LibraryManagmentSystem.LMS.DTO.RequestBookDto;
import com.LibraryManagmentSystem.LMS.Entity.Author;
import com.LibraryManagmentSystem.LMS.Entity.Book;
import com.LibraryManagmentSystem.LMS.Repository.BookRepo;
import com.LibraryManagmentSystem.LMS.Repository.authorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
    @Autowired
    BookRepo bookRepo;
    @Autowired
    authorRepo repo;
    public void addBook(RequestBookDto book){
        Book book1=new Book();
        book1.setGenre(book.getGenre());
        book1.setPrice(book.getPrice());
        book1.setTitle(book.getTitle());
        book1.setAvailable(true);
        Author author=repo.findById(book.getAuthorId()).get();
        List<Book>writtenBooks=new ArrayList<>(author.getAllBooksWrittenByAuthor());
        writtenBooks.add(book1);
        author.setAllBooksWrittenByAuthor(writtenBooks);
        book1.setAuthor(author);
        repo.save(author);
    }
}
