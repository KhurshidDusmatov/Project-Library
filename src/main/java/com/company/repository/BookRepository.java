package com.company.repository;

import com.company.db.DataBase;
import com.company.dto.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringArrayPropertyEditor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BookRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Book> getBookList(){
        String sql = "select * from book";
        List<Book> books = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Book.class));
        if (books.size()>0){
            return books;
        }
        return null;
    }

    public int addBook(Book book){
        String sql = "insert into book(title,author,publish_year,amount) values ('%s','%s','%s','%s')";
        sql = String.format(sql, book.getTitle(), book.getAuthor(), book.getPublishYear(), book.getAmount());
        int n = jdbcTemplate.update(sql);
        return n;
    }

    public int deleteBook(String id) {
        String sql = "update book set visible = false where id = "+ id;
        int n = jdbcTemplate.update(sql);
        return n;
    }

}
