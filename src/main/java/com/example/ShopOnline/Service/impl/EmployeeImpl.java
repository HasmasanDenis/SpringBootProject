package com.example.ShopOnline.Service.impl;
import com.example.ShopOnline.Dto.EmployeeDTO;
import com.example.ShopOnline.Dto.LoginDTO;
import com.example.ShopOnline.Entity.Employee;
import com.example.ShopOnline.Repo.EmployeeRepo;
import com.example.ShopOnline.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.ShopOnline.LoginMessage;

@Service
    public class EmployeeImpl implements EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public String addEmployee(EmployeeDTO employeeDTO){
        Employee employee = new Employee(
                employeeDTO.getEmployeeid(),
                employeeDTO.getEmpoyeename(),
                employeeDTO.getEmail(),


                this.passwordEncoder.encode(employeeDto.getPassword())
        );

        employeeRepo.save(employee);

        return employee.getEmployeename();

    }

    EmployeeDTO employeeDTO;

    @Override
    public LoginMessage loginEmployee(LoginDTO loginDTO) {
        String msg = "";
        Employee employee1 =
                employeeRepo.findByEmail(loginDTO.getEmail());
        if (employee1 != null) {
            String password = loginDTO.getPassword();
            Sting encodedPassword = employee1.getPassword();
            Boolean isPwsdRight = passwordEncoder.matches(password, encodedPassword);

            if (isPwsdRight) {
                Optional<Employee> employee =
                        employeeRepo.findOneByEmailAndPassword(loginDTO.getEmail(), encodedPassword);
                if (employee.isPresent()) {
                    return new LoginMessage("Login Success", true);
                } else {
                    return new LoginMessage("Login Failed", false);
                }
            } else {
                return new LoginMessage("Password Not Match", false);
            }
        }
        retrun new LoginMessage("Email do not exist", false);
    }
}

}
