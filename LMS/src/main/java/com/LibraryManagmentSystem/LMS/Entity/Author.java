package com.LibraryManagmentSystem.LMS.Entity;

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
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int authorId;
    private String name;
    @Column(unique = true)
    private String mobile;
    @OneToMany(mappedBy = "author",cascade = CascadeType.ALL)
    private List<Book>AllBooksWrittenByAuthor=new ArrayList<>();
}
