package com.example.library.book;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BookControllerTests {

   @Autowired
   private BookController bookController;

   @Test
   @Order(1)
   public void insertABook_StatusOk() {
      assertEquals(HttpStatus.OK,
            bookController.insertBook("Miami Test Book").getStatusCode());
   }

   @Test
   @Order(2)
   public void insertTheSameBook_StatusBadRequest() {
      assertEquals(HttpStatus.BAD_REQUEST,
            bookController.insertBook("Miami Test Book").getStatusCode());
   }

   @Test
   @Order(3)
   public void findABookById_StatusOk() {
      assertEquals(HttpStatus.OK,
            bookController.getBookById(1l).getStatusCode());
   }

   @Test
   @Order(4)
   public void findABookByWrongId_StatusBadRequest() {
      assertEquals(HttpStatus.BAD_REQUEST,
            bookController.getBookById(2l).getStatusCode());
   }

   @Test
   @Order(5)
   public void findAListOfBooks_StatusOk() {
      assertEquals(HttpStatus.OK,
            bookController.getAllBooks().getStatusCode());
   }

   @Test
   @Order(6)
   public void updateBook_StatusOk() {
      assertEquals(HttpStatus.OK,
            bookController.updateBook(1l, "new title").getStatusCode());
   }

   @Test
   @Order(7)
   public void updateBookSameTitle_StatusBadRequest() {
      bookController.insertBook("Miami Test Book");
      assertEquals(HttpStatus.BAD_REQUEST,
            bookController.updateBook(2l, "new title").getStatusCode());
   }

   @Test
   @Order(8)
   public void updateBookWrongId_StatusBadRequest() {
      assertEquals(HttpStatus.BAD_REQUEST,
            bookController.updateBook(99l, "unknown book").getStatusCode());
   }

   @Test
   @Order(9)
   public void deleteBookById_StatusOk() {
      assertEquals(HttpStatus.OK,
            bookController.deleteBook(1l).getStatusCode());
   }
}
