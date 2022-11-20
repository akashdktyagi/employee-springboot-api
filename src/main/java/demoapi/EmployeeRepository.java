package demoapi;

import demoapi.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//Query select * from Employee insert into
//SQL
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    List<Employee> findByName(String name);
}
