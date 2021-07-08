package com.example.springvalidation.dao;

import com.example.springvalidation.ds.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {
    @Query("select  b from Book b where b.author.name =:name")
    List<Book> findBookByAuthorName(@Param("name") String name);
}
