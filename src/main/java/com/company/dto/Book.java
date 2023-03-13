package com.company.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    private Integer id;
    private String title;
    private String author;
    private Integer publishYear;
    private Integer amount;
    private Boolean visible;


    public Book(String title, String author, Integer publishYear, Integer amount, Boolean visible) {
        this.title = title;
        this.author = author;
        this.publishYear = publishYear;
        this.amount = amount;
        this.visible = visible;
    }
}
