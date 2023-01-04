package com.example.library.book;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;

@Entity
public class Book implements Serializable {

   @Id
   @GeneratedValue (strategy = GenerationType.IDENTITY)
   private Long bookId;

   @Column (length = 50, nullable = false, unique = true)
   private String title;

   public Book() { }

   public Book(String title) {
      this.setTitle(title);
   }

   public Long getBookId() {
      return bookId;
   }

   public void setBookId(Long bookId) {
      this.bookId = bookId;
   }

   public String getTitle() {
      return title;
   }

   public void setTitle(String title) {
      this.title = title;
   }
}