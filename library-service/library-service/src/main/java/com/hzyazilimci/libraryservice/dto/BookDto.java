package com.hzyazilimci.libraryservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class BookDto {

    private BookIdDto bookIdDto;
    private String title;
    private Integer bookYear;
    private String author;
    private String pressName;

    public BookDto(BookIdDto idDto){
        this.bookIdDto = idDto;
    }
}
