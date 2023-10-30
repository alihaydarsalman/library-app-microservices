package com.hzyazilimci.libraryservice.service;

import com.hzyazilimci.libraryservice.dto.AddBookRequest;
import com.hzyazilimci.libraryservice.dto.LibraryDto;

public interface LibraryService {

    LibraryDto getAllBooksInLibraryById(String id);
    LibraryDto createLibrary();
    void addBookToLibrary(AddBookRequest request);
}
