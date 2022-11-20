package demoapi;

import demoapi.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

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
}
