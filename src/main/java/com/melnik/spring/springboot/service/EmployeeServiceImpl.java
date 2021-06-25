package com.melnik.spring.springboot.service;


import com.melnik.spring.springboot.dao.EmployeeRepository;
import com.melnik.spring.springboot.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployee(int id) {
        Employee employee = null;
        Optional<Employee> optional = employeeRepository.findById(id);
        if (optional.isPresent()) {
            employee = optional.get();
        }
        return employee;
    }

    @Override
    public List<Employee> findAllByName(String name) {
        List<Employee> employeeList = employeeRepository.findAllByName(name);
        return employeeList;
    }

    @Override
    public void deleteEmployee(int id) {
        employeeRepository.deleteById(id);
    }
}
