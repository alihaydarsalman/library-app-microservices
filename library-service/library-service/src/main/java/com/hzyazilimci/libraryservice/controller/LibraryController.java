package com.hzyazilimci.libraryservice.controller;

import com.hzyazilimci.libraryservice.dto.AddBookRequest;
import com.hzyazilimci.libraryservice.dto.LibraryDto;
import com.hzyazilimci.libraryservice.service.LibraryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/library")
public class LibraryController {

    Logger logger = LoggerFactory.getLogger(LibraryController.class);
    private final LibraryService service;
    private final Environment environment;

    @Autowired
    public LibraryController(LibraryService service, Environment environment) {
        this.service = service;
        this.environment = environment;
    }

    @GetMapping("{libId}")
    public ResponseEntity<LibraryDto> getAllBooksInLibraryById(@PathVariable String libId){
        return ResponseEntity.ok(this.service.getAllBooksInLibraryById(libId));
    }

    @PostMapping
    public ResponseEntity<LibraryDto> createLibrary(){
        return ResponseEntity.ok(this.service.createLibrary());
    }

    @PutMapping
    public ResponseEntity<Void> addBookToLibrary(@RequestBody AddBookRequest request){
        logger.info("Library created on port number: "+ environment.getProperty("local.server.port"));
        this.service.addBookToLibrary(request);
        return ResponseEntity.ok().build();
    }
    @GetMapping
    public ResponseEntity<List<String>> getAllLibraries(){
        return ResponseEntity.ok(this.service.getAllLibraries());
    }
}
