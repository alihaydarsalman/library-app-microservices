package com.hzyazilimci.bookservice;

import com.hzyazilimci.bookservice.model.Book;
import com.hzyazilimci.bookservice.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import java.util.Arrays;

@SpringBootApplication
@EnableDiscoveryClient //for EUREKA registiration
public class BookServiceApplication implements CommandLineRunner {

	BookRepository repository;

	public BookServiceApplication(BookRepository repository) {
		this.repository = repository;
	}

	public static void main(String[] args) {
		SpringApplication.run(BookServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {


		Book book1 = Book.builder()
				.author("Platon")
				.title("Devlet")
				.bookYear(2013)
				.pressName("İskele Yayınları")
				.isbn("9944-942-41-3")
				.build();

		Book book2 = Book.builder()
				.author("Franz Kafka")
				.title("DAVA")
				.bookYear(2019)
				.pressName("Can Yayınevi")
				.isbn("978-975-07-2225-7")
				.build();

		Book book3 = Book.builder()
				.author("Albert Einstein")
				.title("İzafiyet Teorisi")
				.bookYear(2016)
				.pressName("SAY Yayınları")
				.isbn("978-975-468-011-9")
				.build();

		System.out.println(this.repository.saveAll(Arrays.asList(book1,book2,book3)));
	}
}
