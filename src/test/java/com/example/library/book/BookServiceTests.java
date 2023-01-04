package com.example.library.book;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class BookServiceTests {

   @Autowired
   BookService bookService;

   @Test
   @Order(1)
   void saveNewBookTest() {
      Book book = new Book("First Book");
      bookService.save(book);
      assertEquals(1l, bookService.count());
   }

   @Test
   @Order(2)
   void successfullyFindBookByIdTest() {
      Long goodId = 1l;
      Book retrievedBook = bookService.findById(goodId).get();
      assertNotNull(retrievedBook);
   }

   @Test
   @Order(3)
   void unsuccessfullyFindBookByIdTest() {
      Long badId = 2l;
      Assertions.assertThrows(BookNotFoundException.class, () -> {
         bookService.findById(badId);
      });
   }

   @Test
   @Order(4)
   void findAllTest() {
      Book book = new Book("Second Book");
      bookService.save(book);
      List<Book> allBooks = bookService.findAll();
      assertEquals(2, allBooks.size());
   }

   @Test
   @Order(5)
   void deleteByIdTest() {
      bookService.deleteById(2l);
      assertEquals(1l, bookService.count());
   }
}