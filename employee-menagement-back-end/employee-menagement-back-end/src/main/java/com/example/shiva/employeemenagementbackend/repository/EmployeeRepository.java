package com.example.shiva.employeemenagementbackend.repository;

import com.example.shiva.employeemenagementbackend.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
