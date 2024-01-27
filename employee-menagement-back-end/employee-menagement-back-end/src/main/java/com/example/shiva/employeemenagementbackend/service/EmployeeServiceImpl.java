package com.example.shiva.employeemenagementbackend.service;

import com.example.shiva.employeemenagementbackend.dto.EmployeeDto;
import com.example.shiva.employeemenagementbackend.entity.Department;
import com.example.shiva.employeemenagementbackend.entity.Employee;
import com.example.shiva.employeemenagementbackend.exception.ResourceNotFoundException;
import com.example.shiva.employeemenagementbackend.mapper.EmployeeMapper;
import com.example.shiva.employeemenagementbackend.repository.DepartmentRepository;
import com.example.shiva.employeemenagementbackend.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {

        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Department department=departmentRepository.findById(employeeDto.getDepartmentId()).orElseThrow(() -> new ResourceNotFoundException("Department is not exits with id: " + employeeDto.getDepartmentId()));
        employee.setDepartment(department);
        Employee saveEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(saveEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee is not found with id: " + id));
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployee() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map(EmployeeMapper::mapToEmployeeDto).collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(long id, EmployeeDto updateEmployee) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee is not  exists with given id : " + id));
        employee.setFirstName(updateEmployee.getFirstName());
        employee.setLastName(updateEmployee.getLastName());
        employee.setEmail(updateEmployee.getEmail());
        Department department=departmentRepository.findById(updateEmployee.getDepartmentId()).orElseThrow(() -> new ResourceNotFoundException("Department is not exits with id: " + updateEmployee.getDepartmentId()));
        employee.setDepartment(department);
        Employee updateEmployeeObj = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(updateEmployeeObj);
    }

    @Override
    public void delete(long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee is not  exists with given id : " + id));
        employeeRepository.delete(employee);

    }


}
