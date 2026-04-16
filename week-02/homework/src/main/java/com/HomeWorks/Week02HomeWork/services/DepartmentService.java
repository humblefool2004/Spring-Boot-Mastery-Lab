package com.HomeWorks.Week02HomeWork.services;

import com.HomeWorks.Week02HomeWork.dto.DepartmentDTO;
import com.HomeWorks.Week02HomeWork.dto.DepartmentUpdateDTO;
import com.HomeWorks.Week02HomeWork.entities.DepartmentEntity;
import com.HomeWorks.Week02HomeWork.repositories.DepartmentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

import java.util.stream.Collectors;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final ModelMapper modelMapper;

    public DepartmentService(DepartmentRepository departmentRepository, ModelMapper modelMapper){
        this.departmentRepository=departmentRepository;
        this.modelMapper=modelMapper;
    }

    public List<DepartmentDTO> getAllDepartments(){
        List<DepartmentEntity> departments = departmentRepository.findAll();
        return departments.stream()
                .map(departmentEntity -> modelMapper.
                        map(departmentEntity,DepartmentDTO.class))
                .collect(Collectors.toList());
    }

    public DepartmentDTO createNewEmployee(DepartmentDTO inputDepartment) {
        DepartmentEntity departmentEntity= modelMapper.map(inputDepartment,DepartmentEntity.class);
        return modelMapper.map(departmentRepository.save(departmentEntity),DepartmentDTO.class);
    }

    public DepartmentDTO updateByDepartmentId(DepartmentDTO inputDepartment, Long departmentId) {
        DepartmentEntity departmentEntity=modelMapper.map(inputDepartment,DepartmentEntity.class);
        departmentEntity.setId(departmentId);
        return modelMapper.map(departmentRepository.save(departmentEntity),DepartmentDTO.class);
    }

    public Boolean deleteDepartmentById(long departmentId) {
        departmentRepository.deleteById(departmentId);
        return true;
    }

    public DepartmentDTO getDepartmentById(long departmentId) {
        return modelMapper.map(departmentRepository.getReferenceById(departmentId),DepartmentDTO.class);
    }


    public DepartmentDTO patchDepartmentById(long departmentId, DepartmentUpdateDTO dto) {
        DepartmentEntity departmentEntity= departmentRepository.findById(departmentId).orElseThrow(()->new RuntimeException("Department not found"));
        modelMapper.map(dto,departmentEntity);
        return modelMapper.map(departmentRepository.save(departmentEntity),DepartmentDTO.class);
    }
}
