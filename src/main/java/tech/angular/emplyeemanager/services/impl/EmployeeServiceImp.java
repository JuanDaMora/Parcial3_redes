package tech.angular.emplyeemanager.services.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.angular.emplyeemanager.dto.EmployeeDTO;
import tech.angular.emplyeemanager.exception.DataNotFoundException;
import tech.angular.emplyeemanager.exception.TransactionException;
import tech.angular.emplyeemanager.mapper.EmployeeMapper;
import tech.angular.emplyeemanager.model.Employee;
import tech.angular.emplyeemanager.repository.IEmployeeRepository;
import tech.angular.emplyeemanager.services.interfaces.IEmployeeService;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @autor Juan David Morantes Vergara
 */
@Service
public class EmployeeServiceImp implements IEmployeeService {
    IEmployeeRepository employeeRepository;


    @Override
    public EmployeeDTO addEmployee(EmployeeDTO employeeDTO) {
        employeeDTO.setEmployeCode(UUID.randomUUID().toString());
        employeeDTO.setImageUrl("https://cdn-icons-png.flaticon.com/128/3135/3135768.png");
        return EmployeeMapper.INSTANCE.toEmployeeDTO(this.employeeRepository.save(EmployeeMapper.INSTANCE.toEmployee(employeeDTO)));
    }

    @Override
    public List<EmployeeDTO> getAllEmployee() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream()
                .map(EmployeeMapper.INSTANCE::toEmployeeDTO).collect(Collectors.toList());
    }

    @Override
    public Employee updateEmployee(EmployeeDTO employeeDTO) {
        //return (findEmployeeById(employeeDTO.getId())!=null)? this.employeeRepository.save(EmployeeMapper.INSTANCE.toEmployee(employeeDTO)): null;
        if(this.employeeRepository.existsById(employeeDTO.getId())){
            return this.employeeRepository.save(EmployeeMapper.INSTANCE.toEmployee(employeeDTO));
        }else{
            throw new TransactionException("Employee not exist");
        }
    }

    @Override
    public Boolean deleteEmployeeById(Long idEmployee) {
        try {
            this.employeeRepository.deleteById(idEmployee);
            return true;
        }catch (Exception e){
            throw new TransactionException("Employee not exist");
        }
    }

    @Override
    public EmployeeDTO findEmployeeById(Long id){
        return EmployeeMapper.INSTANCE.toEmployeeDTO(this.employeeRepository.findById(id)
                .orElseThrow((() -> new DataNotFoundException("Employee not found"))));
    }

    @Autowired
    public void setEmployeeRepository(IEmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
}
