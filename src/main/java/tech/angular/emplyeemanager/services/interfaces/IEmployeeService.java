package tech.angular.emplyeemanager.services.interfaces;

import tech.angular.emplyeemanager.dto.EmployeeDTO;
import tech.angular.emplyeemanager.model.Employee;

import java.util.List;

/**
 * @autor Juan David Morantes Vergara
 */
public interface IEmployeeService {
    EmployeeDTO addEmployee(EmployeeDTO employeeDTO);
    List<EmployeeDTO> getAllEmployee();
    Employee updateEmployee(EmployeeDTO employeeDTO);

    Boolean deleteEmployeeById(Long idEmployee);
    EmployeeDTO findEmployeeById(Long id);
}
