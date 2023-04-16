package com.LibraryManagmentSystem.LMS.Repository;

import com.LibraryManagmentSystem.LMS.Entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface authorRepo extends JpaRepository<Author,Integer> {
}
