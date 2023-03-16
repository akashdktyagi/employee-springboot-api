package demoapi;

import demoapi.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin("*")
@CrossOrigin(origins = "http://localhost:3000")
public class EmployeeController {

    @PostMapping("/init_db")
    public void initDB(){
        Employee employee = Employee.builder().withName("Akash").withAge(23).withAge(37).withEmail("a@a.com").withPhone("12345").withDepartment("HR").withSalary("35345").withDesignation("Director").build();
        Employee employee1 = Employee.builder().withName("Amit").withAge(23).withEmail("b@a.com").withPhone("34546").withDepartment("GK").withSalary("456466").withDesignation("Manager").build();
        Employee employee2 = Employee.builder().withName("Sumit").withAge(23).withEmail("c@a.com").withPhone("45656").withDepartment("BV").withSalary("65546").withDesignation("Director").build();
        createNewEmployee(employee);
        createNewEmployee(employee1);
        createNewEmployee(employee2);
    }

    @Autowired
    EmployeeService employeeService;

    @Autowired
    EmployeeServiceRestTemplate employeeServiceRestTemplate;

    @GetMapping("/employee")
    public List<Employee> getAllEmployee(){
        return employeeService.getAllEmployees();
    }

    @GetMapping("/justAnotherEndPoint")
    public String justAnotherEndPoint(){
        return "Hello";
    }

    @GetMapping("/employee/{name}")
    public List<Employee> getEmployeeByName(@PathVariable String name) throws Exception {
        List<Employee> listOfemployees = employeeService.getEmployeeByName(name);
        if (listOfemployees.isEmpty()){
            throw new Exception("Employee with name as '" + name + "' not found.");
        }else{
            return listOfemployees;
        }
    }

    @PostMapping("/employee")
    public void createNewEmployee(@RequestBody Employee employee){
        employeeService.createANewEmployee(employee);
    }

    @PutMapping("/employee")
    public ResponseEntity<String> editEmployee(@RequestBody Employee employee) throws EmployeeDoesNotExistException {
        employeeService.editEmployee(employee);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Employee Edited: " + employee);
    }

    @DeleteMapping("/employee/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Integer id) throws EmployeeDoesNotExistException{
        employeeService.deleteEmployeeById(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Employee deleted with id as: "+ id);
}

    @GetMapping("/pet/{status}")
    public String getMyPet(@PathVariable String status){
        return employeeServiceRestTemplate.getMyPetWithStatusAs(status);
    }
}
