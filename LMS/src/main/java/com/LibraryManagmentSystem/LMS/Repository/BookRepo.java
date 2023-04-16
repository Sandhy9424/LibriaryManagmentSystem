package com.LibraryManagmentSystem.LMS.Repository;

import com.LibraryManagmentSystem.LMS.Entity.Book;
import com.LibraryManagmentSystem.LMS.Enum.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepo extends JpaRepository<Book,Integer> {
    List<Book> findByGenre(Genre genre);
}
