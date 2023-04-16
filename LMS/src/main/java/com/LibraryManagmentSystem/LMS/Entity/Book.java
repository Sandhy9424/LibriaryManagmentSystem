package com.LibraryManagmentSystem.LMS.Entity;

import com.LibraryManagmentSystem.LMS.Enum.Genre;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookId;
    private String title;
    @Enumerated(EnumType.STRING)
    private Genre genre;
    private int price;
    private boolean isAvailable;
    @ManyToOne
    @JoinColumn
    Author author;
    @OneToMany(mappedBy = "book",cascade = CascadeType.ALL)
    private List<Transaction>transactions=new ArrayList<>();
    @ManyToOne
    @JoinColumn
    private libraryCard card;
}
