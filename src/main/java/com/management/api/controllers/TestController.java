package com.management.api.controllers;

import com.management.api.dao.AddressDao;
import com.management.api.dao.EmployeeDao;
import com.management.api.models.Address;
import com.management.api.models.Employee;
import com.management.api.services.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private AddressDao addressDao;

      @Autowired
      private TestService testService;


      @GetMapping("/check")
       public ResponseEntity<?> check()
       {
                return ResponseEntity.status(HttpStatus.OK).body(this.testService);
//                return ResponseEntity.status(HttpStatus.OK).build();

       }


//       @PostMapping("/abc")
//       public ResponseEntity<?> test()
//       {
//         Employee e = new Employee("adnan","khan","20");
//
//         Address address = new Address("khategaon");
//
//         e.setAddress(address);
//         this.employeeDao.save(e);
//         return ResponseEntity.status(HttpStatus.OK).build();
//       }

       @PostMapping("/abc123")
       public ResponseEntity<?> test1(@RequestBody Employee employee)
       {
         System.out.println(employee);
         this.employeeDao.save(employee);
         return ResponseEntity.status(HttpStatus.OK).build();
       }


}
