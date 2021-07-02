package kg.megacom.emp_salaries_service.services;

import kg.megacom.emp_salaries_service.models.entity.Employee;

public interface SalaryService {

    void setSalaryForEmployee(double salary, Employee employee);
}
