package kg.megacom.emp_salaries_service.services.impl;

import kg.megacom.emp_salaries_service.dao.SalaryRepo;
import kg.megacom.emp_salaries_service.models.entity.Employee;
import kg.megacom.emp_salaries_service.models.entity.Salary;
import kg.megacom.emp_salaries_service.services.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;

@Service
public class SalaryServiceImpl implements SalaryService {

    @Autowired
    private SalaryRepo salaryRepo;

    private void createNewSalary(double salary,Employee employee){

        Salary newSalary = new Salary();
        newSalary.setSalary(salary);
        newSalary.setEmployee(employee);
        newSalary.setStartDate(new Date());

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH,31);
        calendar.set(Calendar.MONTH,12);
        calendar.set(Calendar.YEAR,2999);
        calendar.set(Calendar.HOUR_OF_DAY,0);
        calendar.set(Calendar.MINUTE,0);
        calendar.set(Calendar.SECOND,0);
        calendar.set(Calendar.MILLISECOND,0);
        newSalary.setEndDate(calendar.getTime());

        salaryRepo.save(newSalary);
    }

    @Override
    public void setSalaryForEmployee(double salary, Employee employee) {
        Salary currentSalary = salaryRepo.findByEmployeeCurrentSalary(employee.getId(), new Date());

        if(currentSalary == null){
            createNewSalary(salary,employee);
        }
        else {
            if (salary != currentSalary.getSalary()){
                Calendar calendar = Calendar.getInstance();
                calendar.add(Calendar.SECOND,-1);
                currentSalary.setEndDate(calendar.getTime());
                salaryRepo.save(currentSalary);

                createNewSalary(salary,employee);
            }
        }

    }

    @Override
    public double findCurrentSalary(Employee employee) {
        Salary salary = salaryRepo.findByEmployeeCurrentSalary(employee.getId(),new Date());
        return salary.getSalary();
    }
}
