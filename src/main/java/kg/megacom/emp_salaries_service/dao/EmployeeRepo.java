package kg.megacom.emp_salaries_service.dao;

import kg.megacom.emp_salaries_service.models.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {

}
