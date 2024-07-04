package com.konar.thymeleafdemo.service;

import com.konar.thymeleafdemo.entity.Employee;

import java.util.List;

public interface EmployeeService {

    Employee save(Employee employee);

    List<Employee> findAll();

    Employee findById(Integer id);

    void deleteById(Integer id);

    void deleteAll();

}
