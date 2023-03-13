package com.company.dto;

import com.company.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Profile {
    private Integer id;
    private String name;
    private String surname;
    private String phone;
    private LocalDateTime createdDate;
    private Boolean visible;
    private String role;

    public Profile(String name, String surname, String phone) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
    }
}
