package com.springapidev.cruddemo.dao;

import com.springapidev.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    // that's it ... no need to write any code
}
