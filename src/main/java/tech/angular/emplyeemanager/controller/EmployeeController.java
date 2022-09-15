package tech.angular.emplyeemanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;
import tech.angular.emplyeemanager.dto.EmployeeDTO;
import tech.angular.emplyeemanager.model.Employee;
import tech.angular.emplyeemanager.services.interfaces.IEmployeeService;

import javax.validation.Valid;
import java.util.List;

/**
 * @autor Juan David Morantes Vergara
 */
@Controller
@RequestMapping("/employee")

public class EmployeeController {
    IEmployeeService employeeService;

    @PostMapping
    public ResponseEntity<EmployeeDTO> addEmployee(@RequestBody EmployeeDTO employeeDTO){return ResponseEntity.ok(this.employeeService.addEmployee(employeeDTO));}

    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> getAllEmployee(){return ResponseEntity.ok(this.employeeService.getAllEmployee());}

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDTO> getById(@Valid @PathVariable Long id){return ResponseEntity.ok(this.employeeService.findEmployeeById(id));

    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id,@RequestBody EmployeeDTO employeeDTO){
        employeeDTO.setId(id);
        return ResponseEntity.ok(this.employeeService.updateEmployee(employeeDTO));
    }

    @DeleteMapping("/{idEmployee}")
    public ResponseEntity<Boolean> deleteEmployeeById(@Valid @PathVariable Long idEmployee){
        return ResponseEntity.ok(this.employeeService.deleteEmployeeById(idEmployee));
    }
    @Autowired
    public void setEmployeeService(IEmployeeService employeeService){
        this.employeeService=employeeService;
    }
}
