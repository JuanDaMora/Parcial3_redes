package tech.angular.emplyeemanager.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import tech.angular.emplyeemanager.dto.EmployeeDTO;
import tech.angular.emplyeemanager.model.Employee;

/**
 * @autor Juan David Morantes Vergara
 */
@Mapper
public interface EmployeeMapper {
    EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);
    Employee toEmployee(EmployeeDTO employeeDTO);
    EmployeeDTO toEmployeeDTO(Employee employee);
}
