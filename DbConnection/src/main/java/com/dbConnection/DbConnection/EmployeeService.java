package com.dbConnection.DbConnection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private final EmployeeRepo employeeRepo;

    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public List<Employee> getEmployee() {
        return employeeRepo.findAll();
    }

    public String createEmployee(Employee employee) {
        Optional<Employee> existingEmployee = employeeRepo.findEmployeeByEmail(employee.getEmail());
        if (existingEmployee.isPresent()) {
            throw new IllegalStateException("Email already taken");
        }
        employeeRepo.save(employee);
        return "Employee saved successfully";
    }


    public String deleteMapping(Long id) {
       boolean exist =  employeeRepo.existsById(id);
        if(!exist){
            throw new IllegalStateException("Employee does not exist with id"+ id + " ...!!");
        }
        employeeRepo.deleteById(id);
        return "Employee With id " + id + " deleted successfully";
    }


    public String updateEmployee(Employee employee) {
        boolean exists = employeeRepo.existsById(employee.getId());
        if (!exists) {
            throw new IllegalStateException("Employee does not exist with id " + employee.getId());
        }
        Employee update = employeeRepo.getById(employee.getId());
        update.setName(employee.getName());
        update.setEmail(employee.getEmail());
        update.setAdd(employee.getAdd());

        Employee updatedEmployee = employeeRepo.save(update);
        return String.valueOf(updatedEmployee);
    }

//    public List<Employee> getAll(Pageable pageable){
//        return employeeRepo.findEmp(pageable);
//    }

//    public List<Employee> getEmployeeByName(String name) {
//        return employeeRepo.findByEmployeeName(name);
//    }



//** Using JsonResponse **//
//    public String createEmployee(Employee employee) {
//        Optional<Employee> existingEmployee = employeeRepo.findEmployeeByEmail(employee.getEmail());
//        if (existingEmployee.isPresent()) {
//            throw new IllegalStateException("Email already taken");
//        }
//        employeeRepo.save(employee);
//        return "Employee saved successfully";
//        return Json.createObjectBuilder()
//                .add("message", "Employee saved successfully")
//                .build();
//    }
}
