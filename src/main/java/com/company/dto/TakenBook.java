package com.company.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TakenBook {
    private Integer id;
    private String title;
    private String author;
    private LocalDateTime created_date;
    private String status;
}
