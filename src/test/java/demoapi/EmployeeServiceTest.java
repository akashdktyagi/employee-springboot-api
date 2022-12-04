package demoapi;

import demoapi.model.Employee;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceTest {

    @InjectMocks
    EmployeeService employeeService;

    @Mock
    EmployeeRepository employeeRepository;

    @Test
    void createANewEmployee() {
        Employee employee = Employee.builder().withName("akash").build();
        Mockito.when(employeeRepository.save(any(Employee.class))).then(returnsFirstArg());

        Employee employeeActual = employeeService.createANewEmployee(employee);
        Assertions.assertThat(employeeActual).isEqualTo(employee);
    }

    @Test
    void getAllEmployees() {
    }

    @Test
    void getEmployeeByName() {
    }

    @Test
    void deleteEmployeeById() {
    }

    @Test
    void editEmployee() {
    }

}