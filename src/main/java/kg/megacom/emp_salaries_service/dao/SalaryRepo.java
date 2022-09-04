package kg.megacom.emp_salaries_service.dao;

import kg.megacom.emp_salaries_service.models.entity.Salary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface SalaryRepo extends JpaRepository<Salary, Long> {

    @Query("select u from Salary u where u.employee.id = ?1 and ?2 between u.startDate and u.endDate")
    Salary findByEmployeeCurrentSalary(Long id, Date date);

    Salary findByEmployeeIdAndStartDateBeforeAndEndDateAfter(Long id, Date today, Date today1);

}
