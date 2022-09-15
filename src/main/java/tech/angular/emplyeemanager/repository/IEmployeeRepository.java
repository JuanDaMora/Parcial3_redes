package tech.angular.emplyeemanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.angular.emplyeemanager.model.Employee;

/**
 * @autor Juan David Morantes Vergara
 */
public interface IEmployeeRepository extends JpaRepository<Employee, Long> {
}
