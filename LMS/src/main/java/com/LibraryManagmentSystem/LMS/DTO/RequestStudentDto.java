package com.LibraryManagmentSystem.LMS.DTO;

import com.LibraryManagmentSystem.LMS.Enum.Department;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RequestStudentDto {
    private String name;
    private String emailId;
    @Enumerated(EnumType.STRING)
    private Department department;
}
