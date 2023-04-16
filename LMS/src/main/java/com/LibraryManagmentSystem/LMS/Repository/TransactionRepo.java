package com.LibraryManagmentSystem.LMS.Repository;

import com.LibraryManagmentSystem.LMS.Entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepo extends JpaRepository<Transaction,Integer> {
}
