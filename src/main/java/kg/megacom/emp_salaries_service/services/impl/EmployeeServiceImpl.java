package kg.megacom.emp_salaries_service.services.impl;

import kg.megacom.emp_salaries_service.dao.EmployeeRepo;
import kg.megacom.emp_salaries_service.exceptions.EmployeeNotFound;
import kg.megacom.emp_salaries_service.mappers.EmployeeMapper;
import kg.megacom.emp_salaries_service.models.dto.EmployeeDto;
import kg.megacom.emp_salaries_service.models.entity.Employee;
import kg.megacom.emp_salaries_service.services.EmployeeService;
import kg.megacom.emp_salaries_service.services.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private SalaryService salaryService;

    @Override
    public EmployeeDto save(EmployeeDto employeeDto) {

        Employee employee = employeeMapper.toEmployee(employeeDto);
        employee = employeeRepo.save(employee);
        employeeDto.setId(employee.getId());
        salaryService.setSalaryForEmployee(employeeDto.getSalary(), employee);

        return employeeMapper.toEmployeeDto(employee, employeeDto.getSalary());

    }

    @Override
    public EmployeeDto update(EmployeeDto employeeDto) {

        Employee employee = employeeRepo.findById(employeeDto.getId()).orElseThrow(() -> new EmployeeNotFound("Сотрудник не найден!"));

        employee = employeeMapper.toEmployee(employeeDto);

        salaryService.setSalaryForEmployee(employeeDto.getSalary(), employee);

        return employeeMapper.toEmployeeDto(employee, employeeDto.getSalary());
    }

    @Override
    public List<EmployeeDto> findAll() {
        List<Employee> employees = employeeRepo.findAll();
        List<EmployeeDto> employeeDtos = employees
                .stream()
                .map(x -> employeeMapper.toEmployeeDto(x, salaryService.findCurrentSalary(x)))
                .collect(Collectors.toList());

        return employeeDtos;
    }

    @Override
    public void delete(Long emp_id) {
        Employee employee = employeeRepo.findById(emp_id).orElseThrow(() -> new EmployeeNotFound("Сотрудник не найден!"));

        employee.setActive(false);
        employeeRepo.save(employee);

    }
}
