<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Register - Company App</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/style.css"/>
</head>
<body>
<main>

	<h1>Register - Company App</h1>

	<aside>
	<nav>
		<ul>
			<li>
				<a href="${pageContext.request.contextPath}/">Home</a>
			</li>
		</ul>
	</nav>
	</aside>

	<section>
		<h2>Registration Form</h2>
		<p>Register a <strong>New Employee</strong> in the system:</p>

		<form action="" method="POST">
			<p class="form-control">
				<label for="employeeId">Employee ID</label>
				<input type="number" name="employeeId" id="employeeId" required="required"
					placeholder="Enter Employee ID..." min="1" max="100000000" step="1">
				<%-- 100,000,000 (100 Million) is much lower than INT_MAX which is (2.1 Billion) --%>
			</p>
			<p class="form-control">
				<label for="employeeName">Employee Name</label>
				<input type="text" name="employeeName" id="employeeName" required="required"
					placeholder="Enter Employee Name..." maxlength="50">
			</p>
			<p class="form-control">
				<label for="employeeAddress">Employee Address</label>
				<input type="text" name="employeeAddress" id="employeeAddress"
					placeholder="Enter Employee Address..." maxlength="150">
			</p>
			<p class="form-control">
				<label for="employeeSalary">Employee Salary</label>
				<input type="number" name="employeeSalary" id="employeeSalary" required="required"
					placeholder="Enter Employee Salary..." min="500" max="100000000" step="1">
				<%-- 100,000,000 (100 Million) is much lower than INT_MAX which is (2.1 Billion) --%>
			</p>
			<p class="form-control">
				<button type="submit">Save</button>
			</p>
		</form>
	</section>

</main>
</body>
</html>
