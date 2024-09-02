package com.example;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.entity.Employee;
import com.example.repository.EmployeeRepository;

@SpringBootTest
class EmpdemoApplicationTests {
	@Autowired
	private EmployeeRepository Repo;

	@Test
	void saveEmployee() {
		Employee emp = new Employee();
		emp.setName("happy");
		emp.setEmail("happy@gmail.com");
		
        emp.setMobile("6203332536");
        emp.setSalary(20000);
		
        Repo.save(emp);
	}
	@Test
	void deleteEmployeeById() {
		Repo.deleteById(3L);
	}
	@Test
	void findbyEmployeeId() {
		Optional<Employee> byId = Repo.findById(200L);
		
	if(byId.isPresent()) {
		Employee employee = byId.get();
		System.out.println(employee.getId());
		System.out.println(employee.getName());
		System.out.println(employee.getMobile());
		System.out.println(employee.getSalary());
	}else {
		System.out.println("No record found");
	}	
	}
	@Test
	void getAllEmployees(){
		 Iterable<Employee> empItr=Repo.findAll();
		 for (Employee employee : empItr) {
			 System.out.println(employee.getId());
				System.out.println(employee.getName());
				System.out.println(employee.getMobile());
				System.out.println(employee.getSalary());
				System.out.println(employee.getEmail());

		}
	}
	@Test
	void findEmployeeByEmail() {
		Optional<Employee> byEmail = Repo.findByEmail("happy@mail.com");
		if(byEmail.isPresent()) {
			Employee employee = byEmail.get();
			System.out.println(employee.getId());
			System.out.println(employee.getName());
			System.out.println(employee.getMobile());
			System.out.println(employee.getSalary());
		}else {
			System.out.println("No record found");
		}	
	}
	@Test
	void findEmployeeByMobile() {
		Optional<Employee> byMobile = Repo.findByMobile("6203332535");
		if(byMobile.isPresent()) {
			Employee employee = byMobile.get();
			System.out.println(employee.getId());
			System.out.println(employee.getName());
			System.out.println(employee.getMobile());
			System.out.println(employee.getSalary());
		}else {
			System.out.println("No record found");
		}	
	}
	@Test
	
	void findEmployeeByEmailAndMobile() {
		Optional<Employee> byMobile = Repo.findByEmailAndMobile("ram@gmail.com","6203332535");
		if(byMobile.isPresent()) {
			Employee employee = byMobile.get();
			System.out.println(employee.getId());
			System.out.println(employee.getName());
			System.out.println(employee.getMobile());
			System.out.println(employee.getSalary());
		}else {
			System.out.println("No record found");
		}	
	}
	@Test
	void findEmployeeByEmailOrMobile() {
		List<Employee> byMobile = Repo.findByEmailOrMobile("happy@gmail.com","6203332537");
		for (Employee employee : byMobile) {
			System.out.println(employee.getId());
			System.out.println(employee.getName());
			System.out.println(employee.getMobile());
			System.out.println(employee.getSalary());
		}
		}
	@Test
	void existsEmployeeByEmail() {
	boolean val = Repo.existsByEmail("happy@gmail.com");
		System.out.println(val);
}
	@Test
	void existsEmployeeByMobile() {
	boolean val = Repo.existsByMobile("6203332535");
		System.out.println(val);
}
	@Test
	void UpdateEmployee() {
		Employee emp = new Employee();
		emp.setId(4);
		emp.setName("stalin");
		emp.setEmail("stali.n@gmail.com");
        emp.setMobile("6203332537");
        emp.setSalary(20000);
		
        Repo.save(emp);
	}
	@Test
	void findQueryByEmailEmployee(){
		Employee emp = Repo.findEmployeeByEmail("ram@gmail.com");
		System.out.println(emp.getName());
		System.out.println(emp.getMobile());
		System.out.println(emp.getSalary());
}
	@Test
	void findQueryByMobileEmployee(){
		Employee emp = Repo.findEmployeeByMobile("6203332535");
		System.out.println(emp.getId());
		System.out.println(emp.getName());
		System.out.println(emp.getSalary());
}
	@Test
	void findQueryByEmailAndMobileEmployee(){
		Employee emp = Repo.findEmployeeByEmailAndMobile("ram@gmail.com","6203332535");
		System.out.println(emp.getId());
		System.out.println(emp.getName());
		System.out.println(emp.getSalary());
}
	@Test
	void findQueryByEmailOrMobileEmployee(){
		List<Employee> byMobile = Repo.findByEmailOrMobile("happy@gmail.com","6203332537");
		for (Employee employee : byMobile) {
			System.out.println(employee.getId());
			System.out.println(employee.getName());
			System.out.println(employee.getMobile());
			System.out.println(employee.getSalary());
		}
}
}

