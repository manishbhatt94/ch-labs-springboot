package com.example.demo.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Employee;

@Repository
public interface EmployeeCrudRepository extends CrudRepository<Employee, Integer> {

	// Note: This is a Native SQL Query (nativeQuery = true) as JPQL / HQL doesn't
	// support
	// INSERT...VALUES query.
	@Modifying
	@Transactional
	@Query(value = "INSERT INTO jpa_employee (employee_id, employee_name, employee_address, employee_salary) VALUES (?1, ?2, 'Chennai, Tamil Nadu', 8000)", nativeQuery = true)
	int insertInternForChennaiOffice(int employeeId, String employeeName);

	@Modifying
	@Transactional
	@Query(value = "UPDATE Employee e SET e.employeeSalary = (e.employeeSalary * 1.05) WHERE e.employeeSalary < :threshold")
	int salaryAppraisalForEmployeesWithSalaryLessThan(@Param("threshold") int maxSalaryThreshold);

}
