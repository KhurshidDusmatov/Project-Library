package com.company.entity;

import com.company.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "student_book")
public class StudentBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "student_id")
    private Integer studentId;
    @Column(name = "book_id")
    private Integer bookId;
    @Column(name = "created_date")
    private LocalDateTime createdDate;
    @Column(name = "status")
    private Status status;
    @Column(name = "returned_date")
    private LocalDate returnedDate;
    @Column(name = "duration")
    private Integer duration;
}

