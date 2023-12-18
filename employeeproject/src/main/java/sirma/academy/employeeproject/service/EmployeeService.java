package sirma.academy.employeeproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sirma.academy.employeeproject.dto.EmployeeDto;
import sirma.academy.employeeproject.mapper.Mapper;
import sirma.academy.employeeproject.model.Employee;
import sirma.academy.employeeproject.repository.EmployeeRepository;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }
    
    public Employee getById(Integer id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public Employee create(EmployeeDto dto) {
        Employee employee = Mapper.fromEmployeeDto(dto);
        return employeeRepository.save(employee);
    }

    public Employee updateById(Integer id, EmployeeDto dto) {
        Employee existingEmployee = employeeRepository.findById(id).orElse(null);
        if (existingEmployee != null) {
            existingEmployee.setFirstName(dto.getFirstName());
            existingEmployee.setLastName(dto.getLastName());
            employeeRepository.save(existingEmployee);
        }

        return existingEmployee;
    }

    public void deleteById(Integer id) {
        employeeRepository.deleteById(id);
    }
}
