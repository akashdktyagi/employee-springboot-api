package com.example.demo;

import com.example.demo.model.Employee;
import com.example.demo.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@RestController
public class DemoApplication {

	@Autowired
	EmployeeService employeeService;

	Employee employee1 = Employee.builder().withId(1).withAge(45).withDepartment("hr").withName("vikas").build();
	Employee employee2 = Employee.builder().withId(1).withAge(45).withDepartment("hr").withName("Akash").build();
	ArrayList<Employee> employeeArrayList = new ArrayList<>();

	public DemoApplication(){
		employeeArrayList.add(employee1);
		employeeArrayList.add(employee2);
	}
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@GetMapping("/employee")
	public List<Employee> getEmployee(){
		return employeeArrayList;
	}

	@GetMapping("/employee/{name}")
	public Object getEmployee(@PathVariable String name) throws Exception {
		if (name.contains("akash"))
			return employeeArrayList.get(1);
		else if (name.contains("vikas")){
			return employeeArrayList.get(0);
		}else{
			return "This Employee '" + name + "'  does not exist.";
		}
	}

	@PostMapping("/employee")
	public void createEmployee(@RequestBody Employee employee){
		employeeService.createANewEmployee(employee);
	}

}
