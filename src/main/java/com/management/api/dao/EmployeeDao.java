package com.management.api.dao;

import com.management.api.dd.Demo;
import com.management.api.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EmployeeDao  extends JpaRepository<Employee,Integer> {

    public Employee findById(int id);

    //SQL NATIVE QUERY....
  @Query(value = "SELECT company_id FROM employee e WHERE e.id = id ",nativeQuery = true)
     public Integer getCompanyIdByEmployeeId(Integer id);

  @Query(value = "SELECT address_id FROM employee e WHERE e.id = id ",nativeQuery = true)
  public Integer getAddressIdByEmployeeId(Integer id);

    @Query(value = "SELECT address_id,company_id FROM employee e WHERE e.id = 1",nativeQuery = true)
    public Demo getAddressIdAndEmployeeIdByEmployeeId();





}
