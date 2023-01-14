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

    public String deleteEmployeeById(Integer id) throws EmployeeDoesNotExistException {
        if (employeeRepository.existsById(id)){
            employeeRepository.deleteById(id);
            return "successfully deleted";
        }else{
            throw new EmployeeDoesNotExistException ("Can not delete the employee with id as : " + id);
        }
    }

    public Employee editEmployee(Employee employee) throws EmployeeDoesNotExistException {
        if (employeeRepository.existsById(employee.getId())){
            return employeeRepository.save(employee);
        }else{
            throw new EmployeeDoesNotExistException ("Can not edit the employee with id as : " + employee.getId());
        }
    }

}
