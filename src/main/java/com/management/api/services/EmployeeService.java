package com.management.api.services;


import com.management.api.models.Employee;

import java.util.List;

public interface EmployeeService {

  public Employee addEmployee(Employee e);
  public List<Employee> getEmployees();
  public Employee getEmployee(int id);
  public void deleteEmployee(int id);
  public Employee updateEmployee(Employee emp);
}
