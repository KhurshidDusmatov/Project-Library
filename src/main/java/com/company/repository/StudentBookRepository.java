package com.company.repository;

import com.company.dto.StudentBook;
import com.company.dto.TakenBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class StudentBookRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<TakenBook> getTakenBookList(Integer id) {
        String sql = "select b.id, b.title, b.author, sb.created_date, sb.status from student_book as sb\n" +
                "join book as b on b.id = sb.book_id where sb.student_id = " + id;
        List<TakenBook> books = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(TakenBook.class ));
        if (books.size() > 0) {
            return books;
        }
        return null;
    }

    public int returnBook(String bookId, Integer studentId) {
        LocalDate date = LocalDate.now();
        String sql = "update student_book set status = '%s', returned_date = '%s' where book_id = '%s' and student_id = '%s'";
        sql = String.format(sql, "RETURNED", date, bookId, studentId);
        int n = jdbcTemplate.update(sql);
        return n;
    }

    public List<StudentBook> getAllStudentBooks(){
        String sql = "select  * from student_book";
        List<StudentBook> books = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(StudentBook.class ));
        if (books.size() > 0) {
            return books;
        }
        return null;
    }
}
