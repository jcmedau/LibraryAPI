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
      Optional<Book> opt = Optional.empty();
      try {
         opt = Optional.of(bookRepository.save(book));
      }
      catch (DataIntegrityViolationException e) { }
      return opt;
   }

   public Optional<Book> updateById(Long id, String title) {
      Optional<Book> search = bookRepository.findById(id);
      Optional<Book> opt = Optional.empty();
      if (search.isPresent()) {
         Book toUpdate = search.get();
         toUpdate.setTitle(title);
         opt = Optional.empty();
         try {
            opt = Optional.of(bookRepository.save(toUpdate));
         }
         catch (DataIntegrityViolationException e) { }
      }
      return opt;
   }
}
