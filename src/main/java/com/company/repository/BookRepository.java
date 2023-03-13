package com.company.repository;

import com.company.db.DataBase;
import com.company.dto.Book;
import org.springframework.beans.propertyeditors.StringArrayPropertyEditor;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BookRepository {

    public List<Book> getBookList(){
        try {
            Connection connection = DataBase.getConnection();
            String sql = "select * from book";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Book> books = new ArrayList<>();
            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String author = resultSet.getString("author");
                int publishYear = resultSet.getInt("publish_year");
                int amount = resultSet.getInt("amount");
                boolean visible = resultSet.getBoolean("visible");
                Book book = new Book(id, title, author, publishYear, amount, visible);
                books.add(book);
            }
            return books;

        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public boolean addBook(Book book) {
        try {
            Connection connection = DataBase.getConnection();
            String sql = "insert into book(title, author, publish_year, amount, visible)" +
                    "values(?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, book.getTitle());
            preparedStatement.setString(2, book.getAuthor());
            preparedStatement.setInt(3, book.getPublishYear());
            preparedStatement.setInt(4, book.getAmount());
            preparedStatement.setString(5, book.getVisible().toString());
            preparedStatement.execute();
            return true;

        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
}
