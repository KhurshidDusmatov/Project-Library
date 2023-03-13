package com.company.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBase {

    public static Connection getConnection() {
        try {
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Jdbs_db", "postgres", "dx721");
            return con;
        } catch (SQLException e) {
            System.out.println(e.getSQLState());
            e.printStackTrace();
            System.exit(-1);
        }
        return null;

    }

    public static void initTable() {

        String book = "create table if not exists book ( \n" +
                "             id serial primary key,\n" +
                "             title varchar(50) not null,\n" +
                "             author varchar(50) not null,\n" +
                "             publish_year integer not null, \n" +
                "             amount integer default 0,\n" +
                "             visible varchar(20) not null ); ";


        String profile = "create table if not exists profile ( \n" +
                "             id serial primary key,\n" +
                "             name varchar(20) not null,\n" +
                "             surname varchar(20) not null,\n" +
                "             phone varchar(12) unique, \n" +
                "             created_date timestamp not null default now(),\n" +
                "             visible varchar(20) not null, \n" +
                "             role varchar not null );";


        String studentBook = "create table if not exists studentBook(\n" +
                "   id serial primary key,\n" +
                "   student_id integer not null,\n" +
                "   book_id integer not null,\n" +
                "   created_date timestamp not null default now(),\n" +
                "   status varchar(20) not null,\n" +
                "   returned_date timestamp not null default now(),\n" +
                "   duration varchar(12) );";

        execute(profile);
        execute(book);
        execute(studentBook);
    }

    private static void execute(String sql) {
        try (Connection connection = getConnection()) {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



}
