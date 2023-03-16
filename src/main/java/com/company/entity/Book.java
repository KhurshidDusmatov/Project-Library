package com.company.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "title")
    private String title;
    @Column(name = "author")
    private String author;
    @Column(name = "publish_year")
    private Integer publishYear;
    @Column(name = "amount")
    private Integer amount;
    @Column(name = "visible")
    private Boolean visible;


    public Book(String title, String author, Integer publishYear, Integer amount, Boolean visible) {
        this.title = title;
        this.author = author;
        this.publishYear = publishYear;
        this.amount = amount;
        this.visible = visible;
    }

}
