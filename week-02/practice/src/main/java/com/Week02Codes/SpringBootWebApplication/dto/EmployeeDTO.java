package com.Week02Codes.SpringBootWebApplication.dto;

import com.Week02Codes.SpringBootWebApplication.annotations.EmployeeRoleValidation;
import com.Week02Codes.SpringBootWebApplication.annotations.PrimeNumberValidation;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {
    private Long id;
    @NotBlank(message = "Name of the employee cannot be empty.")
    @Size(min=3,max=10, message = "Number of characters in the name should be in the range : [3,10].")
    private String name;

    @NotBlank(message = "Email should not be null.")
    @Email(message= "Email should be a valid email.")
    private String email;

    @NotNull(message = "Age should not be null.")
    @Max(value=80, message="Age cannot be greater than 80.")
    @Min(value=18,message="Age cannot be less than 18.")
   // @PrimeNumberValidation
    private Integer age;

    @PastOrPresent(message = "Date of joining cannot be in the future.")
    private LocalDate dateOfJoining;

    @NotBlank(message = "The role of employee cannot be blank.")
  //  @Pattern(regexp = "^(ADMIN|USER)$",message = "The role of employee can be USER or ADMIN")
    @EmployeeRoleValidation
    private String role; //ADMIN OR USER

    @NotNull
    @Digits(integer = 6,fraction = 2, message = "The salary can be of the form xxxxxx.xx")
    @DecimalMax(value = "100000.99")
    @DecimalMin(value = "100.05")
    private Double salary;

    @AssertTrue(message = "Employee should be active.")
    @JsonProperty("isActive")
    private Boolean isActive;

    /*
    public EmployeeDTO() {

    }

    public EmployeeDTO(Long id, String name, String email, Integer age, LocalDate dateOfJoining, Boolean isActive) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
        this.dateOfJoining = dateOfJoining;
        this.isActive = isActive;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public LocalDate getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(LocalDate dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }
    */
}
