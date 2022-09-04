package kg.megacom.emp_salaries_service.services;

import kg.megacom.emp_salaries_service.models.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {

    EmployeeDto save(EmployeeDto employeeDto);

    EmployeeDto update(EmployeeDto employeeDto);

    List<EmployeeDto> findAll();

    void delete(Long emp_id);
}
