package com.hzyazilimci.libraryservice.client;

import com.hzyazilimci.libraryservice.dto.BookDto;
import com.hzyazilimci.libraryservice.dto.BookIdDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "book-service", path = "/v1/books")
public interface BookServiceFeignClient {

    @GetMapping("/isbn/{isbn}")
    ResponseEntity<BookIdDto> findByIsbn(@PathVariable String isbn);

    @GetMapping("/id/{id}")
    ResponseEntity<BookDto> findBookDetailsById(@PathVariable String id);
}
