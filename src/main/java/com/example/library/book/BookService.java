package com.example.library.book;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

   private final BookRepository bookRepository;

   public BookService(BookRepository bookRepository) {
      this.bookRepository = bookRepository;
   }

   public Long count () {
      return bookRepository.count();
   }

   public void deleteById (Long id) {
      bookRepository.deleteById(id);
   }

   public List<Book> findAll() {
      return bookRepository.findAll();
   }

   public Optional<Book> findById (Long id) {
      return bookRepository.findById(id);
   }

   public Optional<Book> save (Book book) {
      try {
         return Optional.ofNullable(bookRepository.save(book));
      }
      catch (DataIntegrityViolationException e) {
         return Optional.empty();
      }
   }

   public Optional<Book> updateById(Long id, String newTitle) {
      return bookRepository.findById(id).map(book -> {
         try {
            book.setTitle(newTitle);
            bookRepository.save(book);
         }
         catch (DataIntegrityViolationException e) {
            return null;
         }
         return book;
      });
   }
}
