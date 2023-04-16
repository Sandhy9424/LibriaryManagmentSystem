package com.LibraryManagmentSystem.LMS.DTO;

import com.LibraryManagmentSystem.LMS.Enum.Genre;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RequestBookDto {
    private String title;
    private Genre genre;
    private int price;
    private int authorId;
}
