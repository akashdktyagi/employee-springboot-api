package demoapi;

import demoapi.model.Employee;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;
import java.util.List;
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

        //Call service method to create a new Emp
        Employee employeeActual = employeeService.createANewEmployee(employee);
        Assertions.assertThat(employeeActual).isEqualTo(employee);
    }

    @Test
    void getAllEmployees() {
        Employee employee1 = Employee.builder().withName("akash").build();
        Employee employee2 = Employee.builder().withName("sumit").build();
        List<Employee> employeeExpected = Arrays.asList(employee1,employee2);
        Mockito.when(employeeRepository.findAll()).thenReturn(employeeExpected);

        //Call service method get all employee
        List<Employee> employeeListActual = employeeService.getAllEmployees();
        Assertions.assertThat(employeeExpected).isEqualTo(employeeListActual);

    }

    @Test
    void getEmployeeByName() {
        Employee employee = Employee.builder().withName("akash").build();
        List<Employee> employeeExpected = Arrays.asList(employee);
        Mockito.when(employeeRepository.findByName("akash")).thenReturn(employeeExpected);

        //Call service method get  employee by name
        List<Employee> employeeListActual = employeeService.getEmployeeByName("akash");
        Assertions.assertThat(employeeExpected).isEqualTo(employeeListActual);
    }

    @Test
    void deleteEmployeeById() throws Exception {
        Mockito.when(employeeRepository.existsById(1)).thenReturn(true);
        String msg = employeeService.deleteEmployeeById(1);
        Assertions.assertThat(msg).isEqualTo("successfully deleted");
    }

    @Test
    void deleteEmployeeById_empDoesNotExist() throws Exception {
        Mockito.when(employeeRepository.existsById(1)).thenReturn(false);
        Assertions.assertThatThrownBy(()->employeeService.deleteEmployeeById(1)).isInstanceOf(Exception.class).hasMessage("Can not delete the employee with id as : 1");
    }

    @Test
    void editEmployee() throws Exception {
        Employee employee = Employee.builder().withId(1).withName("akash").build();
        Mockito.when(employeeRepository.existsById(1)).thenReturn(true);
        Mockito.when(employeeRepository.save(employee)).thenReturn(employee);

        Employee employeeActual  = employeeService.editEmployee(employee);
        Assertions.assertThat(employeeActual).isEqualTo(employee);
    }

}