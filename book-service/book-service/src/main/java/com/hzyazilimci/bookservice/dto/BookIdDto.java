package com.hzyazilimci.bookservice.dto;

import com.hzyazilimci.bookservice.model.Book;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class BookIdDto {

    private String id;
    private String isbn;

    public static BookIdDto convert(Book book){
        BookIdDto dto = BookIdDto.builder()
                .id(book.getId())
                .isbn(book.getIsbn())
                .build();

        return dto;
    }
}
