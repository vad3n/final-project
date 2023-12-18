package sirma.academy.employeeproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sirma.academy.employeeproject.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
    
}
