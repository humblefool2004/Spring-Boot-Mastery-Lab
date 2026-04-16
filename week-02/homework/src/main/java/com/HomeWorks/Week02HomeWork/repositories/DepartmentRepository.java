package com.HomeWorks.Week02HomeWork.repositories;

import com.HomeWorks.Week02HomeWork.entities.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<DepartmentEntity,Long> {
}
