package com.dbConnection.DbConnection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class Controller {

    @Autowired
    private final EmployeeService employeeService;

    public Controller(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/getEmployee")
    public List<Employee> getEmployee(){
        return employeeService.getEmployee();
    }

    @PostMapping("/createEmployee")
    public String createEmployee(@RequestBody Employee employee){
        return employeeService.createEmployee(employee);
    }

    @PutMapping("/update")
    public String updateCustomer(@RequestBody Employee employee){
        return employeeService.updateEmployee(employee);
    }

    @DeleteMapping("/{id}")
    public String deleteEmployee(@RequestParam Employee id){
        return employeeService.deleteMapping(id.getId());
    }


//    @GetMapping("/pageable")
//    public List<Employee> getAll(Pageable pageable){
//        return employeeService.getAll(pageable);
//    }
//

    //** using PathVariable **//
//    @DeleteMapping(path = "{employeeId}")
//    public String deleteEmployee(@PathVariable("employeeId") Long id){
//        return employeeService.deleteMapping(id);
//    }

//    @GetMapping("/getEmployeeByName/{name}")
//    public List<Employee> getByName(@PathVariable String name){
//        return employeeService.getEmployeeByName(name);
//    }



}
