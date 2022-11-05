package com.example.demo.services;

import com.example.demo.model.Employee;
import com.example.demo.repository.IEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    IEmployeeRepository employeeRepository;

    public void createANewEmployee(Employee employee){
        employeeRepository.save(employee);
    }

}
