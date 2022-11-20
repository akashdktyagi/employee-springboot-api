package demoapi;

import demoapi.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/*
akash
 */
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

    // Edit
    @PutMapping
    public void editEmployee(){

    }

    //Delete
    @DeleteMapping("/employee/{id}")
    public void deleteEmployee(@PathVariable Integer id){
        employeeService.deleteEmployeeById(id);
    }
}
