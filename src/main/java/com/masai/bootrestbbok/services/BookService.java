package com.masai.bootrestbbok.services;

import java.util.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.masai.bootrestbbok.dao.BookRepositoery;
import com.masai.bootrestbbok.entities.Book;



@Component
public class BookService {

    @Autowired
    private BookRepositoery bookRepositoery;

    // public static List<Book> li =new ArrayList<>();

    // static{

    // li.add(new Book(2,"efgh","xyz"));
    // li.add(new Book(3,"ijkl","abc"));
    // li.add(new Book(4,"mnop","def"));
    // li.add(new Book(5,"qrst","ijk"));

    // }

    public List<Book> getAllBooks() {
        List<Book> list = (List<Book>) this.bookRepositoery.findAll();

        return list;
    }

    public Book getBookById(int id) {
        Book book = null;
        // book= li.stream().filter(e->e.getId()==id).findFirst().get();
        // return book;
        book = this.bookRepositoery.findById(id);
        return book;
    }

    public Book addBook(Book b) {
        // li.add(b);
        // return b;

        Book bk = bookRepositoery.save(b);
        return bk;
    }

    public void deleteBook(int bid) {
        // li=li.stream().filter(e-> e.getId()!=bid).collect(Collectors.toList());

        bookRepositoery.deleteById(bid);

    }
}
