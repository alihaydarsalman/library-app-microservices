package com.hzyazilimci.libraryservice.controller;

import com.hzyazilimci.libraryservice.dto.AddBookRequest;
import com.hzyazilimci.libraryservice.dto.LibraryDto;
import com.hzyazilimci.libraryservice.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/library")
public class LibraryController {

    private final LibraryService service;

    @Autowired
    public LibraryController(LibraryService service) {
        this.service = service;
    }

    @GetMapping("{id}")
    public ResponseEntity<LibraryDto> getAllBooksInLibraryById(@PathVariable String id){
        return ResponseEntity.ok(this.service.getAllBooksInLibraryById(id));
    }

    @PostMapping
    public ResponseEntity<LibraryDto> createLibrary(){
        return ResponseEntity.ok(this.service.createLibrary());
    }

    @PutMapping
    public ResponseEntity<Void> addBookToLibrary(@RequestBody AddBookRequest request){
        this.service.addBookToLibrary(request);
        return ResponseEntity.ok().build();
    }
}
