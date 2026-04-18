package com.HomeWorks.Week02HomeWork.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

//FOR POST mapping
public class DepartmentCreateDTO {

    @NotBlank(message = "Title cannot be empty")
    @Size(min=2,max=50,message = "Title must be between 2 and 50")
    private String title;

    private Boolean active;
}
