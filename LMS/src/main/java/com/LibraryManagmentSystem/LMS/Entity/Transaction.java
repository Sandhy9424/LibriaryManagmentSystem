package com.LibraryManagmentSystem.LMS.Entity;

import com.LibraryManagmentSystem.LMS.Enum.TransactionStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @GeneratedValue(strategy = GenerationType.UUID)
    private String transactionNo;
    @Enumerated(EnumType.STRING)
    private TransactionStatus transactionStatus;
    @CreatedDate
    private Date dateOfTransaction;
    @LastModifiedDate
    private Date lastModifiedDate;
    @ManyToOne
    @JoinColumn
    private Book book;
    @ManyToOne
    @JoinColumn
    private libraryCard card;
}
