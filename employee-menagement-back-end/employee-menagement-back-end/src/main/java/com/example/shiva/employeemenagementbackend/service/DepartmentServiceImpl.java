package com.example.shiva.employeemenagementbackend.service;

import com.example.shiva.employeemenagementbackend.dto.DepartmentDto;
import com.example.shiva.employeemenagementbackend.entity.Department;
import com.example.shiva.employeemenagementbackend.exception.ResourceNotFoundException;
import com.example.shiva.employeemenagementbackend.mapper.DepartmentMapper;
import com.example.shiva.employeemenagementbackend.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public DepartmentDto createDepartment(DepartmentDto departmentDto) {
        Department department = DepartmentMapper.mapToDepartment(departmentDto);
        Department saveDepartment = departmentRepository.save(department);
        return DepartmentMapper.mapToDepartmentDto(saveDepartment);
    }

    @Override
    public DepartmentDto getDepartmentById(long id) {
        Department department=departmentRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Department is not exists with a given id : "+id));
        return DepartmentMapper.mapToDepartmentDto(department);
    }

    @Override
    public List<DepartmentDto> getAllDepartment() {
        List<Department> department=departmentRepository.findAll();
        return department.stream().map((departments)->DepartmentMapper.mapToDepartmentDto(departments)).collect(Collectors.toList());
    }

    @Override
    public DepartmentDto updateDepartment(long id, DepartmentDto departmentDto) {
       Department department= departmentRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Department is not exists with a given id : "+id));
       department.setDepartmentName(departmentDto.getDepartmentName());
       department.setDepartmentDescription(departmentDto.getDepartmentDescription());
       Department savedDepartment=departmentRepository.save(department);
       return DepartmentMapper.mapToDepartmentDto(savedDepartment);
    }

    @Override
    public void deleteDepartment(long id) {
      departmentRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Department is not exists with a given id : "+id));
      departmentRepository.deleteById(id);
    }
}
