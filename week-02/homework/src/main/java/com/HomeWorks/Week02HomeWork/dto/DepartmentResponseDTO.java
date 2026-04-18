package com.HomeWorks.Week02HomeWork.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentResponseDTO {

    private Long id;

    private String title;

    private Boolean active;

    private LocalDate createdAt;
}