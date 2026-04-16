package com.Week02Codes.SpringBootWebApplication.repositories;

import com.Week02Codes.SpringBootWebApplication.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {
   // List<EmployeeEntity> findByName(String name);
}
