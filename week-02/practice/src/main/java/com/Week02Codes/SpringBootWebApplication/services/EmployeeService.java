package com.Week02Codes.SpringBootWebApplication.services;

import com.Week02Codes.SpringBootWebApplication.dto.EmployeeDTO;
import com.Week02Codes.SpringBootWebApplication.entities.EmployeeEntity;
import com.Week02Codes.SpringBootWebApplication.exceptions.ResourceNotFoundException;
import com.Week02Codes.SpringBootWebApplication.repositories.EmployeeRepository;
import org.modelmapper.ModelMapper;

import org.springframework.data.util.ReflectionUtils;
import org.springframework.stereotype.Service;



import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;
    public EmployeeService(EmployeeRepository employeeRepository,ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }


    public Optional<EmployeeDTO> findEmployeeById(long id) {
        Optional<EmployeeEntity> employee = employeeRepository.findById(id);
        return employee.map(entity -> modelMapper.map(entity, EmployeeDTO.class));
    }


    public List<EmployeeDTO> getAllEmployees() {
        List<EmployeeEntity> employees = employeeRepository.findAll();
        return  employees.stream()
                .map(employeeEntity -> modelMapper.map(employeeEntity,EmployeeDTO.class))
                .collect(Collectors.toList());
    }

    public EmployeeDTO createNewEmployee(EmployeeDTO inputEmployee) {
        EmployeeEntity employeeEntity = modelMapper.map(inputEmployee,EmployeeEntity.class);
        EmployeeEntity saveEmployeeEntity = employeeRepository.save(employeeEntity);
        return modelMapper.map(saveEmployeeEntity,EmployeeDTO.class);
    }

    public EmployeeDTO updateEmployeeById(long employeeId, EmployeeDTO inputEmployee) {
        isExistById(employeeId);
        EmployeeEntity employeeEntity = modelMapper.map(inputEmployee,EmployeeEntity.class);
        employeeEntity.setId(employeeId);
        EmployeeEntity saveEmployeeEntity = employeeRepository.save(employeeEntity);
        return modelMapper.map(saveEmployeeEntity,EmployeeDTO.class);
    }

    private void isExistById(long id) {
        boolean exists = employeeRepository.existsById(id);
        if (!exists) {
            throw new ResourceNotFoundException("Employee with id: " + id + " not found");
        }
    }

    public boolean deleteEmployeeById(long employeeId) {
        isExistById(employeeId);

        employeeRepository.deleteById(employeeId);
        return true;
    }

    public EmployeeDTO patchEmployeeById(long employeeId, Map<String,Object> updates) {
        isExistById(employeeId);

        EmployeeEntity employeeEntity = employeeRepository.findById(employeeId).get();
        updates.forEach((field,value)->{
            Field fieldToUpdate = ReflectionUtils.findRequiredField(EmployeeEntity.class,field);
            fieldToUpdate.setAccessible(true);
            ReflectionUtils.setField(fieldToUpdate,employeeEntity,value);
        });

        employeeRepository.save(employeeEntity);

        return modelMapper.map(employeeRepository.save(employeeEntity),EmployeeDTO.class);

    }
}
