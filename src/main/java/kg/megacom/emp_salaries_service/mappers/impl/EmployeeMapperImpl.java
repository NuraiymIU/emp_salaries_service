package kg.megacom.emp_salaries_service.mappers.impl;

import kg.megacom.emp_salaries_service.mappers.EmployeeMapper;
import kg.megacom.emp_salaries_service.models.dto.EmployeeDto;
import kg.megacom.emp_salaries_service.models.entity.Employee;
import org.springframework.stereotype.Service;

@Service
public class EmployeeMapperImpl implements EmployeeMapper {

    @Override
    public Employee toEmployee(EmployeeDto employeeDto) {

        Employee employee = new Employee();

        if(employeeDto.getId() != null){
           employee.setId(employeeDto.getId());
        }
        employee.setName(employeeDto.getName());
        employee.setSurname(employeeDto.getSurname());
        employee.setActive(employeeDto.isActive());
        return employee;
    }

    @Override
    public EmployeeDto toEmployeeDto(Employee employee, double salary) {

        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setName(employee.getName());
        employeeDto.setSurname(employee.getSurname());
        employeeDto.setActive(employee.isActive());
        employeeDto.setSalary(salary);
        employeeDto.setId(employee.getId());
        return employeeDto;
    }


}
