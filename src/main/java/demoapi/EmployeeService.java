package demoapi;

import demoapi.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class EmployeeService {
    EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee createANewEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public List<Employee> getEmployeeByName(String name) {
        return employeeRepository.findByName(name);
    }

    public String deleteEmployeeById(Integer id) throws Exception {
        if (employeeRepository.existsById(id)){
            employeeRepository.deleteById(id);
            return "successfully deleted";
        }else{
            throw new Exception ("Employee does not exist. Can not delete");
        }
    }

//    public Employee editEmployee(Employee employee) throws Exception {
//        if (employeeRepository.existsById(employee.getId())){
//            return employeeRepository.save(employee);
//        }else{
//            throw new Exception ("Employee does not exist. Can not edit");
//        }
//    }

    public Employee editEmployee(Employee employee) throws Exception {
        if (employeeRepository.existsById(employee.getId())){
            return employeeRepository.save(employee);
        }else{
            throw new EmployeeNotFoundException ("Employee does not exist with id as : " + employee.getId() + " . Can not edit");
        }
    }

}
