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
    RestTemplate restTemplate;
    EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(RestTemplate restTemplate, EmployeeRepository employeeRepository) {
        this.restTemplate = restTemplate;
        this.employeeRepository = employeeRepository;
    }

    public void createANewEmployee(Employee employee){
        employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public List<Employee> getEmployeeByName(String name) {
        return employeeRepository.findByName(name);
    }

    public void deleteEmployeeById(Integer id) throws Exception {
        if (employeeRepository.existsById(id)){
            employeeRepository.deleteById(id);
        }else{
            throw new Exception ("Employee does not exist. Can not delete");
        }
    }

    public void editEmployee(Employee employee) throws Exception {
        if (employeeRepository.existsById(employee.getId())){
            employeeRepository.save(employee);
        }else{
            throw new Exception ("Employee does not exist. Can not edit");
        }
    }

    public String getMyPetWithStatusAs(String status){
        ResponseEntity<Object> responseEntity = restTemplate.getForEntity("/v2/pet/findByStatus?status="+status,Object.class);
        return String.valueOf(responseEntity.getBody());
    }
}
