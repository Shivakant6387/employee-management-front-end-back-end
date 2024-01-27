package com.example.shiva.employeemenagementbackend.repository;

import com.example.shiva.employeemenagementbackend.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {
}
