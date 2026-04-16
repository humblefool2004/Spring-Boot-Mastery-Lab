package com.HomeWorks.Week02HomeWork.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
//using this for the patchMapping input
public class DepartmentUpdateDTO {
    private String title;

    private Boolean active;

    private LocalDate createdAt;
}
