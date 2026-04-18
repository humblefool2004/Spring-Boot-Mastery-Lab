package com.HomeWorks.Week02HomeWork.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//using this for the patchMapping input
public class DepartmentPatchDTO {

    private String title;

    private Boolean active;

    //private LocalDate createdAt; removed because non update able.
}
