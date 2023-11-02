package com.hzyazilimci.bookservice.controller;

import com.hzyazilimci.bookservice.dto.BookIdDto;
import com.hzyazilimci.bookservice.dto.GetBookDto;
import com.hzyazilimci.bookservice.service.BookService;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/books")
@Validated
public class BookController {

    private final BookService service;

    @Autowired
    public BookController(BookService service) {
        this.service = service;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<GetBookDto>> getAllBooks(){
        return ResponseEntity.ok(this.service.getAllBooks());
    }

    @GetMapping("/isbn/{isbn}")
    public ResponseEntity<BookIdDto> findByIsbn(@PathVariable(value = "isbn") @NotEmpty String isbn){
        return ResponseEntity.ok(this.service.findByIsbn(isbn));
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<GetBookDto> findBookDetailsById(@PathVariable(value = "id") @NotEmpty String id){
        return ResponseEntity.ok(this.service.findBookDetailsById(id));
    }

    @GetMapping("/test")
    public ResponseEntity<String> findBookDetailsById(){
        return ResponseEntity.ok("DENEME CALISIYOR.");
    }
}
