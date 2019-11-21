package com.example.hello.hellodemo.repository;

import com.example.hello.hellodemo.model.Book;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by sunyuqing on 2019/9/20.
 */
@Repository
public interface BookRepository extends CrudRepository<Book,Integer> {

    default Book insertBook(String title, String content, long publishDate, float price) {
        Book book = new Book();
        book.setTitle(title);
        book.setContent(content);
        book.setPrice(price);
        book.setPublicationDate(publishDate);
        return save(book);
    }

    //curd中的所有方法都可应用到对应的键上
    Iterable<Book> findAllByTitle(String name);

    @Query(value = "select * from book where title like %?1% or content like %?1%",
            nativeQuery = true)
    Iterable<Book> search(String query);

    

}
