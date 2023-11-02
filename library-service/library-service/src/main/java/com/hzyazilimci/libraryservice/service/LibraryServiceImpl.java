package com.hzyazilimci.libraryservice.service;

import com.hzyazilimci.libraryservice.client.BookServiceFeignClient;
import com.hzyazilimci.libraryservice.dto.AddBookRequest;
import com.hzyazilimci.libraryservice.dto.LibraryDto;
import com.hzyazilimci.libraryservice.model.Library;
import com.hzyazilimci.libraryservice.repository.LibraryRepository;
import com.hzyazilimci.libraryservice.util.exception.LibraryNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LibraryServiceImpl implements LibraryService{

    private final LibraryRepository repository;
    private final BookServiceFeignClient bookFeignClient;

    @Autowired
    public LibraryServiceImpl(LibraryRepository repository, BookServiceFeignClient bookFeignClient) {
        this.repository = repository;
        this.bookFeignClient = bookFeignClient;
    }

    @Override
    public LibraryDto getAllBooksInLibraryById(String libId) {

        Library library = this.repository.findById(libId)
                .orElseThrow(() -> new LibraryNotFoundException("Library not found with id. ID: "+libId));

        return LibraryDto.builder()
                .id(library.getId())
                .bookDtoList(library.getBookIds()
                        .stream()
                        .map(bookFeignClient::findBookDetailsById) //feign
                        .map(ResponseEntity::getBody)
                        .collect(Collectors.toList()))
                .build();
    }

    @Override
    public LibraryDto createLibrary() {

       Library newLib = this.repository.save(new Library());

        return LibraryDto.builder()
                .id(newLib.getId())
                .build();
    }

    @Override
    public void addBookToLibrary(AddBookRequest request){

        Library library = this.repository.findById(request.getId())
                .orElseThrow(() -> new LibraryNotFoundException("Library not found with id. ID: "+request.getId()));

        String bookId = bookFeignClient.findByIsbn(request.getIsbn()).getBody().getId();

        library.getBookIds().add(bookId);

        this.repository.save(library);
    }

    @Override
    public List<String> getAllLibraries() {
        return this.repository.findAll()
                .stream()
                .map(Library::getId)
                .collect(Collectors.toList());
    }
}
