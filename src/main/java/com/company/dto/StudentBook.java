package com.company.dto;

import com.company.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentBook {
    private Integer id;
    private Integer studentId;
    private Integer bookId;
    private LocalDateTime createdDate;
    private Status status;
    private LocalDate returnedDate;
    private Integer duration;
}

