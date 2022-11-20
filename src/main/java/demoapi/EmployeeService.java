package demoapi;

import demoapi.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public Employee createANewEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public List<Employee> getEmployeeByName(String name) throws Exception {
        List<Employee> listOfemployees = employeeRepository.findByName(name);
        if (listOfemployees.isEmpty()){
            throw new Exception("Employee with name as '" + name + "' not found.");
        }else{
            return listOfemployees;
        }
    }

    public void deleteEmployeeById(Integer id) {
        employeeRepository.deleteById(id);
    }

    public void updateExistingEmployee(Employee employee) throws Exception {
        if (employeeRepository.existsById(employee.getId())){
            employeeRepository.save(employee);
        }else{
            throw new Exception("Employee ID not found");
        }
    }
}
