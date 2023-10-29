package com.hzyazilimci.bookservice.service;

import com.hzyazilimci.bookservice.dto.BookIdDto;
import com.hzyazilimci.bookservice.dto.GetBookDto;
import com.hzyazilimci.bookservice.repository.BookRepository;
import com.hzyazilimci.bookservice.util.exception.BookNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService{

    private final BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<GetBookDto> getAllBooks() {
        return GetBookDto.convert(this.bookRepository.findAll());
    }

    @Override
    public BookIdDto findByIsbn(String isbn) {
        return this.bookRepository.findBookByIsbn(isbn)
                .map(BookIdDto::convert)
                .orElseThrow(() -> new BookNotFoundException("Book could not found by isbn. ISBN: "+isbn));
    }

    @Override
    public GetBookDto findBookDetailsById(String id) {
        return this.bookRepository.findById(id)
                .map(book -> GetBookDto.convert(book))
                .orElseThrow(() -> new BookNotFoundException("Book could not found by id. ID: "+id));
    }
}
