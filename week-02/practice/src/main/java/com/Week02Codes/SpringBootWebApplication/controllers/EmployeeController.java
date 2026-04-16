package com.Week02Codes.SpringBootWebApplication.controllers;

import com.Week02Codes.SpringBootWebApplication.dto.EmployeeDTO;

import com.Week02Codes.SpringBootWebApplication.exceptions.ResourceNotFoundException;
import com.Week02Codes.SpringBootWebApplication.services.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
/*    @GetMapping(path = "/getSecret")
//    public String getYourSecretMessage(){
//        return "Secret Message is : askdgjaslgjd#@df";
   }*/

//injecting the employee repository. this is a bad practise, later we will learn service layer to do this.
    //private final EmployeeRepository employeeRepository;
    private final EmployeeService employeeService;
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/{employeeId}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable(name="employeeId") long id){
        Optional<EmployeeDTO> employeeDTO= employeeService.findEmployeeById(id);
        return employeeDTO
                .map(ResponseEntity::ok)
                .orElseThrow(()-> new ResourceNotFoundException("Employee was not found with id : "+id));
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees(@RequestParam(required = false) Integer age,
                                                @RequestParam(required = false) String sort){
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @PostMapping
    public  ResponseEntity<EmployeeDTO> createNewEmployee(@RequestBody @Valid EmployeeDTO inputEmployee){
        return new ResponseEntity<>(employeeService.createNewEmployee(inputEmployee), HttpStatus.CREATED);
    }

    @PutMapping(path="/{employeeId}")
    public ResponseEntity<EmployeeDTO> updateEmployeeById(@RequestBody @Valid EmployeeDTO inputEmployee,@PathVariable long employeeId){

        return ResponseEntity.ok(employeeService.updateEmployeeById(employeeId, inputEmployee));
    }

    @DeleteMapping(path="/{employeeId}")
    public ResponseEntity<Boolean> deleteEmployeeById(@PathVariable long employeeId){
        boolean gotDeleted=employeeService.deleteEmployeeById(employeeId);
        if(gotDeleted){
            return ResponseEntity.ok(true);
        }
        return ResponseEntity.notFound().build();
    }

    @PatchMapping(path="/{employeeId}")
    public ResponseEntity<EmployeeDTO> patchEmployeeById(@PathVariable long employeeId,
                                         @RequestBody Map<String,Object> updates){
        EmployeeDTO updatedEmployee = employeeService.patchEmployeeById(employeeId, updates);
        if(updatedEmployee != null){
            return ResponseEntity.ok(updatedEmployee);
        }
        return ResponseEntity.notFound().build();
    }
}
