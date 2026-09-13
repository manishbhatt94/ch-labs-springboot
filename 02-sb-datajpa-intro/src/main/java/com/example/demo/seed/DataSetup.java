package com.example.demo.seed;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeCrudRepository;

@Component
public class DataSetup {

	private final EmployeeCrudRepository empCrudRepository;

	public DataSetup(EmployeeCrudRepository empCrudRepository) {
		super();
		this.empCrudRepository = empCrudRepository;
	}

	@PostConstruct
	public void doSetup() {
//		seedEmployees();
	}

	public void seedEmployees() {
		List<Employee> employeesToSave = EmployeeData.getEmployees();
		System.out.println("[DataSetup.seedEmployees] Seeding " + employeesToSave.size() + " employee records...");
		empCrudRepository.saveAll(employeesToSave);
		System.out.println("[DataSetup.seedEmployees] Done Seeding.");
	}

}
