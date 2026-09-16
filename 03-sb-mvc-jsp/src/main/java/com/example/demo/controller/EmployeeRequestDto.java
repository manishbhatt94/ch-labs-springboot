package com.example.demo.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeRequestDto {

	private int employeeId;

	private String employeeName;

	private String employeeAddress;

	private int employeeSalary;

}
