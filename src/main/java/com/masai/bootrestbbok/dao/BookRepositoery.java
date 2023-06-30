package com.masai.bootrestbbok.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.bootrestbbok.entities.Book;



public interface BookRepositoery extends JpaRepository<Book,Integer>{
    public Book findById(int Id);

    
    
}
