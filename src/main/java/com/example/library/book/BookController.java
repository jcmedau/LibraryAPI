package com.example.library.book;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {

   private BookService bookService;

   public BookController(BookService bookService) {
      this.bookService = bookService;
   }

   @DeleteMapping("/deleteBook/{id}")
   public ResponseEntity<Book> deleteBook(@PathVariable Long id) {
      bookService.deleteById(id);
      return ResponseEntity.status(HttpStatus.OK).build();
   }

   @GetMapping("/getBooks")
   public ResponseEntity<List<Book>> getAllBooks() {
      return ResponseEntity.status(HttpStatus.OK).body(bookService.findAll());
   }

   @GetMapping("/getBook/{id}")
   public ResponseEntity<Book> getBook(@PathVariable Long id) {
      return bookService.findById(id).map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.badRequest().build());
   }

   @GetMapping("/")
   public ResponseEntity<String> hello() {
      return ResponseEntity.status(HttpStatus.OK).body("Hello from Spring Boot!");
   }

   @PostMapping("/insert")
   public ResponseEntity<Book> insertBook(@RequestParam String title) {
      return bookService.save(new Book(title)).map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.badRequest().build());
   }

   @PostMapping("/update")
   public ResponseEntity<Book> updateBook(@RequestParam Long id, String title) {
      return bookService.updateById(id, title).map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.badRequest().build());
   }
}
