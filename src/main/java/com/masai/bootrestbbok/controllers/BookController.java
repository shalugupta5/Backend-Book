package com.masai.bootrestbbok.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import com.masai.bootrestbbok.entities.Book;
import com.masai.bootrestbbok.services.BookService;

@RestController
@CrossOrigin("*")
public class BookController {
  
    @Autowired
    private BookService bs;

    @GetMapping("/books")
    public ResponseEntity<Object> getBook(){

      List<Book> li =this.bs.getAllBooks();

      if(li.size()<=0){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); 
      }

      return ResponseEntity.status(HttpStatus.CREATED).body(li);

      // return this.bs.getAllBooks();
    }

    @GetMapping("/books/{id}")
    public Book getBookById(@PathVariable("id") Integer id){
        return bs.getBookById(id);
    }


    @PostMapping("/books")
    public Book addBook(@RequestBody Book b){
        Book book=null;
      book= this.bs.addBook(b);
      return book;
    }
    @DeleteMapping("/books/{bid}")
    public void deleteBookById(@PathVariable Integer bid){
    this.bs.deleteBook(bid);

    }

}
