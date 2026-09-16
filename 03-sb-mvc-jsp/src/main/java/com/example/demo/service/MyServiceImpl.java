package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.controller.EmployeeRequestDto;
import com.example.demo.entity.EmployeeEntity;
import com.example.demo.repository.EmployeeRepository;

@Service
public class MyServiceImpl implements MyService {

	private final EmployeeRepository employeeRepository;

	public MyServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@Override
	public EmployeeEntity save(EmployeeRequestDto employeeRequestDto) {

		EmployeeEntity empToSave = new EmployeeEntity();
		empToSave.setEmployeeId(employeeRequestDto.getEmployeeId());
		empToSave.setEmployeeName(employeeRequestDto.getEmployeeName());
		empToSave.setEmployeeAddress(employeeRequestDto.getEmployeeAddress());
		empToSave.setEmployeeSalary(employeeRequestDto.getEmployeeSalary());

		return employeeRepository.save(empToSave);
	}

}
