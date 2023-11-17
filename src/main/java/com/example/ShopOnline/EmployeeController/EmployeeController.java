package com.example.ShopOnline.EmployeeController;
import org.springframework.web.bind.annotation.*;
import com.example.ShopOnline.Entity.Employee;

@RestController
@CrossOrigin
@RequestMapping("api/v1/employee")

public class EmployeeController {

    @PostMapping(path = "/save")
    public String saveEmployee(@RequestBody Employee employeeDTO)
    {
        String id = employeeService.addEmployee(employeeDTO);
        return id;
    }



}
