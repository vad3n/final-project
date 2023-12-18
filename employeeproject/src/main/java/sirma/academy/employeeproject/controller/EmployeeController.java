package sirma.academy.employeeproject.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sirma.academy.employeeproject.dto.EmployeeDto;
import sirma.academy.employeeproject.model.Employee;
import sirma.academy.employeeproject.service.EmployeeService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("api/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<?> getAll() {
        List<Employee> employees = employeeService.getAll();

        if (employees.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(employees, HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id) {
        Employee employee = employeeService.getById(id);

        if (employee == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody EmployeeDto dto) {
        try {
            //Employee employee = employeeService.create(dto);
            return ResponseEntity.ok("Successfully create employee");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Could not create employee");   
        }
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> updateById(@PathVariable Integer id, @RequestBody EmployeeDto dto) {
        try {
            Employee employee = employeeService.updateById(id, dto);

            if (employee == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            
            return ResponseEntity.ok("Successfully update employee");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Could not update employee");   
        }
    }

    @DeleteMapping
    public ResponseEntity<?> deleteById(@PathVariable Integer id) {
        employeeService.deleteById(id);
        return ResponseEntity.ok("Successfully delete employee");
    }

}
