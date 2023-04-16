package com.LibraryManagmentSystem.LMS.Service;

import com.LibraryManagmentSystem.LMS.DTO.RequestAuthorDto;
import com.LibraryManagmentSystem.LMS.DTO.RequestBookDto;
import com.LibraryManagmentSystem.LMS.Entity.Author;
import com.LibraryManagmentSystem.LMS.Entity.Book;
import com.LibraryManagmentSystem.LMS.Enum.Genre;
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
    public List<Book> findAllAvailableBook(){
        List<Book>bookList=new ArrayList<>();
        for(Book b:bookRepo.findAll()){
            if(b.isAvailable()){
                bookList.add(b);
            }
        }
        return bookList;
    }
    public List<Book> findByAuthor(RequestAuthorDto authorDto){
        List<Book>bookList=new ArrayList<>();
        for(Book b: bookRepo.findAll()){
            if(b.getAuthor().getMobile().equals(authorDto.getMobile())){
                bookList.add(b);
            }
        }
        return bookList;
    }
    public List<Book> findByGenre(Genre genre){
        return bookRepo.findByGenre(genre);
    }
}
