package com.example.demoapi;

import com.example.demoapi.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/employee")
    public List<Employee> getAllEmployee(){
        return employeeService.getAllEmployees();
    }

    @PostMapping("/employee")
    public void createNewEmployee(@RequestBody Employee employee){
        employeeService.createANewEmployee(employee);
    }

    //    Employee employee0 = Employee.builder().withId(1).withName("Akash").withEmail("a@a.com").build();
//    Employee employee1 = Employee.builder().withId(1).withName("Sarang").withAge(100).withEmail("s@s.com").build();
//    Employee employee2 = Employee.builder().withId(2).withName("manish").withAge(50).withEmail("m@m.com").build();
//    List<Employee> employeeList = new ArrayList<>();


//    @GetMapping("/employee/{name}")
//    public Object getEmployee(@PathVariable String name){
//        if (name.contains("akash")){
//            return employee0;
//        }else if (name.contains("sarang")){
//            return employee1;
//        }else if (name.contains("manish")){
//            return employee2;
//        }else{
//            return "Error: no such employee exists. " + name;
//        }
//    }
}
