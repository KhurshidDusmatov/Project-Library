package com.company.repository;

import com.company.dto.StudentBook;
import com.company.dto.TakenBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentBookRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<TakenBook> getTakenBookList(Integer id) {
        String sql = "select b.title, b.author, sb.created_date from student_book as sb\n" +
                "join book as b on b.id = sb.book_id where sb.status = 'TAKEN' and sb.student_id = " + id;
        List<TakenBook> books = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(TakenBook.class ));
        if (books.size() > 0) {
            return books;
        }
        return null;
    }
}
