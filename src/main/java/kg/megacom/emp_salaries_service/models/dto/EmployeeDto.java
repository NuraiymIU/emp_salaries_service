package kg.megacom.emp_salaries_service.models.dto;

import lombok.Data;

@Data
public class EmployeeDto {

    private Long id;
    private String name;
    private String surname;
    private double salary;
    private boolean active;
}
