package demoapi;

import demoapi.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@ResponseBody
public class EmployeeController {

    @PostMapping("/init_db")
    public void initDB(){
        Employee employee = Employee.builder().withName("Akash").build();
        Employee employee1 = Employee.builder().withName("Amit").build();
        Employee employee2 = Employee.builder().withName("Sumit").build();
        createNewEmployee(employee);
        createNewEmployee(employee1);
        createNewEmployee(employee2);
    }

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/employee")
    public ResponseEntity<String> getAllEmployee(){
        try{
            List<Employee> listOfemployees = employeeService.getAllEmployees();
            return ResponseEntity.status(HttpStatus.OK).body(listOfemployees.toString());
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Exception thrown: " + e.getMessage());
        }
    }

    @GetMapping("/employee/{name}")
    public ResponseEntity<String> getEmployeeByName(@PathVariable String name) throws Exception {
        try {
            List<Employee> listOfemployees = employeeService.getEmployeeByName(name);
            return ResponseEntity.status(HttpStatus.OK).body(listOfemployees.toString());
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Exception thrown: " + e.getMessage());
        }
    }

    @PostMapping("/employee")
    public ResponseEntity<String> createNewEmployee(@RequestBody Employee employee){
        try{
            Employee emp = employeeService.createANewEmployee(employee);
            return ResponseEntity.status(HttpStatus.CREATED).body(emp.toString());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Exception thrown: " + e.getMessage());
        }
    }

    @PutMapping("/employee")
    public ResponseEntity<String> editEmployee(@RequestBody Employee employee) throws Exception {
        try{
            employeeService.updateExistingEmployee(employee);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Employee Updated");
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Employee not found.");
        }
    }

    @DeleteMapping("/employee/{id}")
    public void deleteEmployee(@PathVariable Integer id){
        employeeService.deleteEmployeeById(id);
    }
}
