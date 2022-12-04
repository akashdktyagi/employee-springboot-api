package demoapi;

import demoapi.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
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

    @Autowired
    EmployeeServiceRestTemplate employeeServiceRestTemplate;

    @GetMapping("/employee")
    public List<Employee> getAllEmployee(){
        return employeeService.getAllEmployees();
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
    public ResponseEntity<String> editEmployee(@RequestBody Employee employee) {
        try{
            employeeService.editEmployee(employee);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Employee Edited: " + employee);
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @DeleteMapping("/employee/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Integer id){
        try{
            employeeService.deleteEmployeeById(id);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Employee deleted with id as: "+ id);
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/pet/{status}")
    public String getMyPet(@PathVariable String status){
        return employeeServiceRestTemplate.getMyPetWithStatusAs(status);
    }
}
