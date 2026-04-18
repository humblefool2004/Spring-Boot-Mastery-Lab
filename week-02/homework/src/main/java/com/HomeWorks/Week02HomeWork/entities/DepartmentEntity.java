package com.HomeWorks.Week02HomeWork.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name ="departments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)  // Requires ModelMapper skipNullEnabled to preserve default
    private Boolean active = true;

    @Setter(AccessLevel.NONE)
    @Column(nullable = false, updatable = false)
    private LocalDate createdAt;

    @PrePersist
    private void initializeCreatedAt(){
        this.createdAt=LocalDate.now();
    }
}
