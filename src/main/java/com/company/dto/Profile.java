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
    private Role role;


}
