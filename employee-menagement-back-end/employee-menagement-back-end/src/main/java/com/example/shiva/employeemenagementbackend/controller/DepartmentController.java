package com.example.shiva.employeemenagementbackend.controller;

import com.example.shiva.employeemenagementbackend.dto.DepartmentDto;
import com.example.shiva.employeemenagementbackend.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/api/departments")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @PostMapping
    public ResponseEntity<DepartmentDto> createDepartment(@RequestBody DepartmentDto departmentDto) {
        DepartmentDto department = departmentService.createDepartment(departmentDto);
        return new ResponseEntity<>(department, HttpStatus.CREATED);
    }
    @GetMapping("{id}")
    public ResponseEntity<DepartmentDto>departmentById(@PathVariable long id){
        DepartmentDto departmentDto=departmentService.getDepartmentById(id);
       return ResponseEntity.ok(departmentDto);
    }
    @GetMapping
    public ResponseEntity<List<DepartmentDto>>getAllDepartment(){
       List<DepartmentDto> department= departmentService.getAllDepartment();
       return ResponseEntity.ok(department);
    }
    @PutMapping("{id}")
    public ResponseEntity<DepartmentDto>updateDepartment(@PathVariable long id,@RequestBody DepartmentDto departmentDto){
       DepartmentDto updateDepartment= departmentService.updateDepartment(id,departmentDto);
       return ResponseEntity.ok(updateDepartment);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteDepartment(@PathVariable long id){
        departmentService.deleteDepartment(id);
        return ResponseEntity.ok("Department deleted Successfully!.");
    }
}
