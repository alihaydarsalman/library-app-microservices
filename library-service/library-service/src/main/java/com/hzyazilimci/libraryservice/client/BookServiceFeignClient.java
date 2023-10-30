package com.hzyazilimci.libraryservice.client;

import com.hzyazilimci.libraryservice.dto.BookDto;
import com.hzyazilimci.libraryservice.dto.BookIdDto;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "book-service", path = "/v1/books")
public interface BookServiceFeignClient {

    Logger logger = LoggerFactory.getLogger(BookServiceFeignClient.class);

    @GetMapping("/isbn/{isbn}")
    @CircuitBreaker(name = "findByIsbnCircuitBreaker", fallbackMethod = "findBookByIsbnFallBack") //fallBackMethod, resilience4j ile ayri bir thread ile calistirilacak.
    ResponseEntity<BookIdDto> findByIsbn(@PathVariable String isbn);

    default ResponseEntity<BookIdDto> findBookByIsbnFallBack(String isbn, Exception exception){
        logger.info("FeignClient ile sorgulanan "+isbn+" isbn degeri icin herhangi bir kayit bulunamadi. BookService' ten donen hata: "+ exception.getMessage());
        return ResponseEntity.ok(new BookIdDto("default","default"));
    }

    @GetMapping("/id/{id}")
    @CircuitBreaker(name = "findBookDetailsByIdCircuitBreaker", fallbackMethod = "findBookDetailsFallBack") //fallBackMethod, resilience4j ile ayri bir thread ile calistirilacak.
    ResponseEntity<BookDto> findBookDetailsById(@PathVariable String id);

    default ResponseEntity<BookDto> findBookDetailsFallBack(String id, Exception exception){
        logger.info("FeignClient ile sorgulanan "+id+" bookId degeri icin herhangi bir kayit bulunamadi. BookService' ten donen hata: "+ exception.getMessage());

        BookIdDto idDto = BookIdDto.builder()
                .id("DEFAULT-BOOK-ID")
                .isbn("DEFAULT-ISBN-789")
                .build();

        return ResponseEntity.ok(new BookDto(idDto));
    }
}
