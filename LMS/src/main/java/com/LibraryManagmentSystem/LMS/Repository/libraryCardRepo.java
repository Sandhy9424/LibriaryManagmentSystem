package com.LibraryManagmentSystem.LMS.Repository;

import com.LibraryManagmentSystem.LMS.Entity.libraryCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface libraryCardRepo extends JpaRepository<libraryCard,Integer> {
}
