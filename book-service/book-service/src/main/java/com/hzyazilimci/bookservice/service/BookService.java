package com.hzyazilimci.bookservice.service;

import com.hzyazilimci.bookservice.dto.BookIdDto;
import com.hzyazilimci.bookservice.dto.GetBookDto;

import java.util.List;

public interface BookService {

    List<GetBookDto> getAllBooks();

    BookIdDto findByIsbn(String isbn);

    GetBookDto findBookDetailsById(String id);
}
