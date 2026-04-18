package com.HomeWorks.Week02HomeWork.services;

import com.HomeWorks.Week02HomeWork.exceptions.ResourceNotFoundException;
import com.HomeWorks.Week02HomeWork.dto.*;
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

    public List<DepartmentResponseDTO> getAllDepartments(){
        List<DepartmentEntity> departments = departmentRepository.findAll();
        return departments.stream()
                .map(departmentEntity -> modelMapper.
                        map(departmentEntity, DepartmentResponseDTO.class))
                .collect(Collectors.toList());
    }

    public DepartmentResponseDTO createNewDepartment(DepartmentCreateDTO inputDepartment) {
        DepartmentEntity departmentEntity= modelMapper.map(inputDepartment,DepartmentEntity.class);
        return modelMapper.map(departmentRepository.save(departmentEntity),DepartmentResponseDTO.class);
    }

    public DepartmentResponseDTO updateDepartment(DepartmentUpdateDTO inputDepartment, Long departmentId) {

        DepartmentEntity entity = departmentRepository.findById(departmentId)
                .orElseThrow(() -> new ResourceNotFoundException("Department not found"));
        modelMapper.map(inputDepartment, entity);
        return modelMapper.map(departmentRepository.save(entity), DepartmentResponseDTO.class);
    }

    public void deleteDepartmentById(long departmentId) {
        departmentRepository.findById(departmentId).orElseThrow(()->new ResourceNotFoundException("Department not found"));
        departmentRepository.deleteById(departmentId);
    }

    public DepartmentResponseDTO getDepartmentById(long departmentId) {
        DepartmentEntity departmentEntity= departmentRepository.findById(departmentId).orElseThrow(()->new ResourceNotFoundException("Department not found"));
        return modelMapper.map(departmentEntity,DepartmentResponseDTO.class);
    }


    public DepartmentResponseDTO patchDepartmentById(long departmentId, DepartmentPatchDTO dto) {
        DepartmentEntity departmentEntity= departmentRepository.findById(departmentId).orElseThrow(()->new ResourceNotFoundException("Department not found"));
        modelMapper.map(dto,departmentEntity);
        return modelMapper.map(departmentRepository.save(departmentEntity),DepartmentResponseDTO.class);
    }
}
