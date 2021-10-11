package com.management.api.controllers;

import com.management.api.dao.EmployeeDao;
import com.management.api.dd.Demo;
import com.management.api.models.Employee;
import com.management.api.services.EmployeeService;
import org.hibernate.annotations.UpdateTimestamp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EmployeeController {

      private static final Logger log = LoggerFactory.getLogger(EmployeeController.class);

     @Autowired
     private EmployeeService employeeService;

     @Autowired
     private EmployeeDao employeeDao;


       //API for create new employee and save in database
      @PostMapping("/add_employee")
      public ResponseEntity<?> addEmployee(@RequestBody Employee emp)
      {
           log.info("The request came on the add employee api");
            Employee tempEmployee = this.employeeService.addEmployee(emp);

            if (!ObjectUtils.isEmpty(tempEmployee))
            {
                 return ResponseEntity.status(HttpStatus.OK).build();
            }else{
              return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
      }

      //API for get all employee whose is store in the database....!!!!
      @GetMapping("/get_employees")
      public ResponseEntity<?> getEmployees()
      {
        List<Employee> list = null;
        list = this.employeeService.getEmployees();
        return ResponseEntity.ok(list);
      }


      //API for --> Get employee by employee_id........!!
      @GetMapping("/get_employee/{id}")
      public ResponseEntity<?> getEmployee(@PathVariable("id") int id)
      {
             Employee emp = this.employeeService.getEmployee(id);
             if(emp != null)
             {
               return ResponseEntity.ok(emp);
             }else{
               return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
             }

      }

      //API for delete an employee..............
      @DeleteMapping("/delete_employee/{id}")
      public ResponseEntity<?> deleteEmployee(@PathVariable("id") int id)
      {

        this.employeeService.deleteEmployee(id);
        return ResponseEntity.status(HttpStatus.OK).build();
      }


      //API for update employee................
      @PutMapping("/update/employee")
      public ResponseEntity<?> updateEmployee(@RequestBody Employee emp)
      {
        Employee tempEmp = this.employeeService.updateEmployee(emp);
        if(tempEmp != null)
        {
          return ResponseEntity.status(HttpStatus.OK).body(tempEmp);
        }else{
          return ResponseEntity.status(HttpStatus.NOT_MODIFIED).build();
        }

      }

      //PRACTICE ...PURPOSE ONLY...!
  @GetMapping("/test1")
  public ResponseEntity<?> pra(@RequestBody Employee employee)
  {
//    Integer n = this.employeeDao.getAddressIdByEmployeeId(id);
//   return ResponseEntity.status(HttpStatus.OK).body(n);

       Demo d = this.employeeDao.getAddressIdAndEmployeeIdByEmployeeId();
          // Object arr = a[0];
            //System.out.print(arr.toString());

            return ResponseEntity.status(HttpStatus.OK).body(d);

//               Integer n1 = this.employeeDao.getAddressIdByEmployeeId(employee.getId());
//               System.out.println(n1);
//               employee.getAddress().setId(n1);
//               Integer n2 = this.employeeDao.getCompanyIdByEmployeeId(employee.getId());
//               employee.getCompany().setId(n2);
//               Employee e = this.employeeService.updateEmployee(employee);
//              return ResponseEntity.status(HttpStatus.OK).body(e);

  }

    @GetMapping("/get_all")
  public ResponseEntity<?> getAll()
  {
      List<Employee> list = this.employeeDao.findAll();
      return ResponseEntity.status(HttpStatus.OK).body(list);
  }

}
