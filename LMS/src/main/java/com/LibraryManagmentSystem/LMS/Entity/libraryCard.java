package com.LibraryManagmentSystem.LMS.Entity;

import com.LibraryManagmentSystem.LMS.Enum.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class libraryCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String ExpiryDate;
    @Enumerated(EnumType.STRING)
    private Status status;
    @OneToOne
    @JoinColumn
    Student student;
    @OneToMany(mappedBy = "card",cascade = CascadeType.ALL)
    private List<Transaction>transactions=new ArrayList<>();
    @OneToMany(mappedBy = "card",cascade = CascadeType.ALL)
    private List<Book>bookList=new ArrayList<>();
}
