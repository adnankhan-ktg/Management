package com.management.api.serviceimpl;

import com.management.api.models.Employee;
import com.management.api.dao.EmployeeDao;
import com.management.api.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

  @Autowired
    private EmployeeDao employeeDao;

  @Override
  public Employee addEmployee(Employee e) {
      return this.employeeDao.save(e);
  }

  @Override
  public List<Employee> getEmployees() {
          List<Employee> list = null;
          try
          {
            list = this.employeeDao.findAll();
            return list;
          }catch (Exception e)
          {
            e.printStackTrace();
            return list;
          }
  }

  @Override
  public Employee getEmployee(int id) {

        Employee emp = null;
        try
        {
           emp = this.employeeDao.findById(id);
          return emp;
        }catch (Exception e)
        {
          e.printStackTrace();
          return emp;
        }
  }

  @Override
  public void deleteEmployee(int id) {

    this.employeeDao.deleteById(id);
  }

  @Override
  public Employee updateEmployee(Employee emp) {

          Employee temp = null;
          try
          {
            temp = this.employeeDao.save(emp);
            return temp;
          }catch (Exception e)
          {
            e.printStackTrace();
            return temp;
          }
  }
}
