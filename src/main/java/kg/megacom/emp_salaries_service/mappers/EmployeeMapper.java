package kg.megacom.emp_salaries_service.mappers;

import kg.megacom.emp_salaries_service.models.dto.EmployeeDto;
import kg.megacom.emp_salaries_service.models.entity.Employee;

public interface EmployeeMapper {
    Employee toEmployee(EmployeeDto employeeDto);

    EmployeeDto toEmployeeDto(Employee employee, double salary);
}
