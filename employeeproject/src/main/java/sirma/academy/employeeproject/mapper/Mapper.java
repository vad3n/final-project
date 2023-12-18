package sirma.academy.employeeproject.mapper;

import sirma.academy.employeeproject.dto.EmployeeDto;
import sirma.academy.employeeproject.model.Employee;

public class Mapper {
    public static Employee fromEmployeeDto(EmployeeDto dto) {
        Employee employee = new Employee();
        employee.setFirstName(dto.getFirstName());
        employee.setLastName(dto.getLastName());
        return employee;
    }
}
