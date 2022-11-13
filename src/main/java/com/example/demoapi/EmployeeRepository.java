package com.example.demoapi;

import com.example.demoapi.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

//Query select * from Employee insert into
//SQL
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
}
