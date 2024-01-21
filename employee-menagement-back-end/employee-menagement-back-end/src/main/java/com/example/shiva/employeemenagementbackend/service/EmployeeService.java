package com.example.shiva.employeemenagementbackend.service;

import com.example.shiva.employeemenagementbackend.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto employeeDto);
    EmployeeDto getEmployeeById(long id);
    List<EmployeeDto>getAllEmployee();
    EmployeeDto updateEmployee(long id,EmployeeDto employeeDto);
    public void delete(long id);
}
