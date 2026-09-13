package com.example.demo.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Employee;

@Repository
public interface EmployeeJpaRepository extends JpaRepository<Employee, Integer> {

	List<Employee> findFirst3PeopleByEmployeeAddressContainingIgnoreCase(String addressPart, Sort sort);

}
