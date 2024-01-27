package com.example.shiva.employeemenagementbackend.service;

import com.example.shiva.employeemenagementbackend.dto.DepartmentDto;

import java.util.List;

public interface DepartmentService {
    DepartmentDto createDepartment(DepartmentDto departmentDto);
    DepartmentDto getDepartmentById(long id);
   List<DepartmentDto> getAllDepartment();
   DepartmentDto updateDepartment(long id, DepartmentDto departmentDto);
   public void deleteDepartment(long id);
}
