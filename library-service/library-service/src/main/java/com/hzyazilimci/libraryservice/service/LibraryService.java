package com.hzyazilimci.libraryservice.service;

import com.hzyazilimci.libraryservice.dto.AddBookRequest;
import com.hzyazilimci.libraryservice.dto.LibraryDto;

import java.util.List;

public interface LibraryService {

    LibraryDto getAllBooksInLibraryById(String libId);
    LibraryDto createLibrary();
    void addBookToLibrary(AddBookRequest request);
    List<String> getAllLibraries();
}
