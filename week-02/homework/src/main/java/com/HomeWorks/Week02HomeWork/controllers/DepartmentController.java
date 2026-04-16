package com.HomeWorks.Week02HomeWork.controllers;


import com.HomeWorks.Week02HomeWork.dto.DepartmentDTO;
import com.HomeWorks.Week02HomeWork.dto.DepartmentUpdateDTO;
import com.HomeWorks.Week02HomeWork.services.DepartmentService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private final DepartmentService departmentService;
    public DepartmentController(DepartmentService departmentService){
        this.departmentService=departmentService;
    }

    @GetMapping
    public List<DepartmentDTO> getAllDepartments(){
        return departmentService.getAllDepartments();
    }

    @PostMapping
    public DepartmentDTO createNewDepartment(@RequestBody @Valid DepartmentDTO inputDepartment){
        return departmentService.createNewEmployee(inputDepartment);
    }

    @PutMapping("/{departmentId}")
    public DepartmentDTO updateByDepartmentId(@RequestBody @Valid DepartmentDTO inputDepartment,@PathVariable Long departmentId){
        return departmentService.updateByDepartmentId(inputDepartment,departmentId);
    }

    @DeleteMapping("/{departmentId}")
    public Boolean deleteDepartmentById(@PathVariable long departmentId){
        return departmentService.deleteDepartmentById(departmentId);
    }

    @GetMapping("/{departmentId}")
    public DepartmentDTO getDepartmentById(@PathVariable long departmentId){
        return departmentService.getDepartmentById(departmentId);
    }

    @PatchMapping("/{departmentId}")
    public DepartmentDTO patchDepartmentById(@PathVariable long departmentId,@RequestBody DepartmentUpdateDTO dto){
        return departmentService.patchDepartmentById(departmentId,dto);
    }

}
