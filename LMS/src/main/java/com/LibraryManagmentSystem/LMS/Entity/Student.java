package com.LibraryManagmentSystem.LMS.Entity;

import com.LibraryManagmentSystem.LMS.Enum.Department;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.id.factory.internal.AutoGenerationTypeStrategy;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rollNo;

    private String name;
    @Column(unique = true)
    private String emailId;
    @Enumerated(EnumType.STRING)
    private Department department;
    @OneToOne(mappedBy = "student",cascade = CascadeType.ALL)
    libraryCard card;
}
