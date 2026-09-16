package com.example.demo.service;

import com.example.demo.controller.EmployeeRequestDto;
import com.example.demo.entity.EmployeeEntity;

public interface MyService {

	EmployeeEntity save(EmployeeRequestDto employeeRequestDto);

}
