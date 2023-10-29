package com.hzyazilimci.bookservice.dto;

import com.hzyazilimci.bookservice.model.Book;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class GetBookDto {

    private BookIdDto bookIdDto;
    private String title;
    private Integer bookYear;
    private String author;
    private String pressName;

    public static GetBookDto convert(Book book){

        return GetBookDto.builder()
                .bookIdDto(BookIdDto.convert(book))
                .title(book.getTitle())
                .bookYear(book.getBookYear())
                .author(book.getAuthor())
                .pressName(book.getPressName())
                .build();
    }

    public static List<GetBookDto> convert(List<Book> books){
        return books.stream().map(GetBookDto::convert).collect(Collectors.toList());
    }
}
