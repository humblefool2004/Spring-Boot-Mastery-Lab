package com.HomeWorks.Week02HomeWork.controllers;


import com.HomeWorks.Week02HomeWork.dto.*;
import com.HomeWorks.Week02HomeWork.services.DepartmentService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    private final DepartmentService departmentService;
    //If multiple constructors → use @Autowired
    public DepartmentController(DepartmentService departmentService){
        this.departmentService=departmentService;
    }

    @GetMapping
    public ResponseEntity<List<DepartmentResponseDTO>> getAllDepartments(){
        List<DepartmentResponseDTO> list=departmentService.getAllDepartments();
        return ResponseEntity.ok(list); //200
    }

    @PostMapping
    public ResponseEntity<DepartmentResponseDTO> createNewDepartment(@RequestBody @Valid DepartmentCreateDTO inputDepartment){
        DepartmentResponseDTO created= departmentService.createNewDepartment(inputDepartment);
        URI location= ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(created.getId())
                .toUri();
        return ResponseEntity.created(location).body(created); //201
    }

    @PutMapping("/{departmentId}")
    public ResponseEntity<DepartmentResponseDTO> updateDepartment(@RequestBody @Valid DepartmentUpdateDTO inputDepartment,
                                                              @PathVariable Long departmentId){
        DepartmentResponseDTO updated= departmentService.updateDepartment(inputDepartment,departmentId);
        return ResponseEntity.ok(updated); //200
    }

    @DeleteMapping("/{departmentId}")
    public ResponseEntity<Void> deleteDepartmentById(@PathVariable long departmentId){
        departmentService.deleteDepartmentById(departmentId);
        return ResponseEntity.noContent().build(); //204
    }

    @GetMapping("/{departmentId}")
    public ResponseEntity<DepartmentResponseDTO> getDepartmentById(@PathVariable long departmentId){
        DepartmentResponseDTO dto= departmentService.getDepartmentById(departmentId);
        return ResponseEntity.ok(dto); //200
    }

    @PatchMapping("/{departmentId}")
    public ResponseEntity<DepartmentResponseDTO> patchDepartmentById(@PathVariable long departmentId,
                                                             @RequestBody @Valid DepartmentPatchDTO dto){
        DepartmentResponseDTO updated=departmentService.patchDepartmentById(departmentId,dto);
        return  ResponseEntity.ok(updated);
    }

}
