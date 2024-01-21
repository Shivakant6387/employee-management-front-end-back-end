package com.example.shiva.employeemenagementbackend.controller;

import com.example.shiva.employeemenagementbackend.dto.EmployeeDto;
import com.example.shiva.employeemenagementbackend.entity.Employee;
import com.example.shiva.employeemenagementbackend.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto) {
        EmployeeDto saveEmployee = employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(saveEmployee, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto>getEmployeeById(@PathVariable long id){
        EmployeeDto employeeDto=  employeeService.getEmployeeById(id);
        return ResponseEntity.ok(employeeDto);
    }
    @GetMapping
    public ResponseEntity<List<EmployeeDto>>getAllEmployee(){
        List<EmployeeDto> employees=employeeService.getAllEmployee();
        return ResponseEntity.ok(employees);
    }
    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDto>updatedEmployee(@PathVariable long id,@RequestBody EmployeeDto updateEmployee){
        EmployeeDto employeeDto=employeeService.updateEmployee(id,updateEmployee);
        return ResponseEntity.ok(employeeDto);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String>deleteEmployee(@PathVariable long id){
     employeeService.delete(id);
     return ResponseEntity.ok("Employee deleted successfully!.");
    }
}
