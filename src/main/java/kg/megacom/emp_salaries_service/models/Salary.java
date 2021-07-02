package kg.megacom.emp_salaries_service.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "salaries")
public class Salary {

    @Id
    @GeneratedValue

    private Long id;
    private double salary;
    private Date startDate;
    private Date endDate;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

}
