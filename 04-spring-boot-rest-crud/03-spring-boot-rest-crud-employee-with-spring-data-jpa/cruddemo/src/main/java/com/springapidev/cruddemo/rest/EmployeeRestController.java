package com.springapidev.cruddemo.rest;

import com.springapidev.cruddemo.dao.EmployeeDAO;
import com.springapidev.cruddemo.entity.Employee;
import com.springapidev.cruddemo.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

   private EmployeeService employeeService;

    // quick and dirty : inject employee dao (use constructor injection)
    public EmployeeRestController(EmployeeService theEmployeeService){
        employeeService = theEmployeeService;
    }

    // expose "/employee" and return a list of employees
    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }
    // add mapping for get/employee/{employeeId}
    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId){
        Employee theEmployee = employeeService.findById(employeeId);
        if(theEmployee == null){
            throw new RuntimeException("Employee id not found - " + employeeId);
        }
        return theEmployee;
    }

    // add mapping for post/employees - add new employee
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee){
        // also just in case they pass an id in json.. set id to 0
        // this is to force a save of new item... instead of update

        theEmployee.setId(0);
        Employee dbEmployee = employeeService.save(theEmployee);
        return dbEmployee;
    }
    // add mapping for put/employees -update existing employee
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee){
        Employee dbEmployee = employeeService.save(theEmployee);
        return dbEmployee;
    }

    // add mapping for delete/employee/{employeeId} -delete employee
    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){
        Employee tempEmployee = employeeService.findById(employeeId);

        // throw exception of null
        if(tempEmployee==null){
            throw new RuntimeException("Employee id not found-" + employeeId);
        }
        employeeService.deleteById(employeeId);
        return "Deleted employee id-"+ employeeId;
    }


}
