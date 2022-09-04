package kg.megacom.emp_salaries_service.controllers;

import kg.megacom.emp_salaries_service.models.dto.EmployeeDto;
import kg.megacom.emp_salaries_service.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/save")
    public EmployeeDto save(@RequestBody EmployeeDto employeeDto) {
        return employeeService.save(employeeDto);
    }

    @PutMapping("/update")
    public EmployeeDto update(@RequestBody EmployeeDto employeeDto) {
        return employeeService.update(employeeDto);
    }

    @GetMapping("/all")
    public List<EmployeeDto> findAll() {
        return employeeService.findAll();
    }

    @DeleteMapping("/delete/{emp_id}")
    public void delete(@PathVariable Long emp_id) {
        employeeService.delete(emp_id);
    }

}


