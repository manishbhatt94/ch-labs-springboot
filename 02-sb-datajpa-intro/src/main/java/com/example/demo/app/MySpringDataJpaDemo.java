package com.example.demo.app;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeCrudRepository;

@Component
public class MySpringDataJpaDemo {

	private final EmployeeCrudRepository crudRepository;

	public MySpringDataJpaDemo(EmployeeCrudRepository crudRepository) {
		this.crudRepository = crudRepository;
	}

	public void doCrudRepositoryDemo() {

		System.out.println("\nInserting record with save() [id = 10076]...");
		Employee emp1 = crudRepository.save(new Employee(10076, "Method Man", "Park Hill Projects, New York", 23000));
		System.out.println("Inserted record: " + emp1);

		System.out.println("\nInserting record with save() [id = 10109]...");
		Employee emp2 = crudRepository.save(new Employee(10109, "Inspectah Deck", "The Bronx, New York", 26300));
		System.out.println("Inserted record: " + emp2);

		System.out.println("\nInserting record with save() [id = 10164]...");
		Employee emp3 = crudRepository.save(new Employee(10164, "Ol' Dirty Bastard", "Queens Bridge, New York", 24500));
		System.out.println("Inserted record: " + emp3);

		System.out.println("\nFinding count with count() ...");
		long count1 = crudRepository.count();
		System.out.println("Count: " + count1);

		System.out.println("\nFinding record by [id = 10076] using findById() ...");
		System.out.println("Record with [id = 10076] is: " + crudRepository.findById(10076).orElse(null));

		System.out.println("\nChecking if record [id = 10076] exists using existsById() ...");
		System.out.println("Record with [id = 10076] exists? : " + crudRepository.existsById(10076));

		System.out.println("\nDeleting record [id = 10076] using existsById() ...");
		crudRepository.deleteById(10076);
		System.out.println("Record with [id = 10076] deleted.");

		System.out.println("\nUpdating record [id = 10109]...");
		emp2.setEmployeeAddress("UPDATED: " + emp2.getEmployeeAddress());
		emp2.setEmployeeName(emp2.getEmployeeName().toUpperCase());
		crudRepository.save(emp2);
		System.out.println("Record with [id = 10109] updated.");

		System.out.println("\nFinding record by [id = 10109] using findById() ...");
		System.out.println("Record with [id = 10109] is: " + crudRepository.findById(10109).orElse(null));

		System.out.println("\nFinding record by [id = 10076] using findById() ...");
		System.out.println("Record with [id = 10076] is: " + crudRepository.findById(10076).orElse(null));

		System.out.println("\nChecking if record [id = 10076] exists using existsById() ...");
		System.out.println("Record with [id = 10076] exists? : " + crudRepository.existsById(10076));

		System.out.println("\nFinding records with id = [10109, 10164] using findAllById() ...");
		List<Employee> allById1 = (List<Employee>) crudRepository.findAllById(Arrays.asList(10109, 10164));
		System.out.println("Records: " + allById1);

		System.out.println("\nDeleting records with id = [10109, 10164] using deleteAllById() ...");
		crudRepository.deleteAllById(Arrays.asList(10109, 10164));
		System.out.println("Deleted records with id = [10109, 10164].");

		System.out.println("\nFinding records with id = [10109, 10164] using findAllById() ...");
		List<Employee> allById2 = (List<Employee>) crudRepository.findAllById(Arrays.asList(10109, 10164));
		System.out.println("Records: " + allById2);

		System.out.println("\nRun Native SQL @Query (INSERT)...");
		int insertRowsAffected = crudRepository.insertInternForChennaiOffice(10187, "Rashmi Balakrishnan");
		System.out.println("Insert done. Rows affected: " + insertRowsAffected);

		System.out.println("\nFinding count with count() ...");
		long count2 = crudRepository.count();
		System.out.println("Count: " + count2);

		System.out.println("\nRun JPQL @Query (UPDATE) - Do 5% increment in salaries of employees "
				+ "whose current salary is less than 50,000 ...");
		int updateRowsAffected = crudRepository.salaryAppraisalForEmployeesWithSalaryLessThan(50000);
		System.out.println("Update done. Rows affected: " + updateRowsAffected);

		System.out.println();

	}

	public void doJpaRepositoryDemo() {

	}

}
