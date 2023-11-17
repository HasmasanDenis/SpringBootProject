package com.example.ShopOnline.Service;
import com.example.ShopOnline.LoginMessage;
import com.example.ShopOnline.Dto.EmployeeDTO;
import com.example.ShopOnline.Dto.LoginDTO;

public interface EmployeeService {
    String addEmployee(EmployeeDTO employeeDTO);

    LoginMessage loginEmployee(LoginDTO loginDTO);

}
