package com.management.api.dd;

public class Demo {
  private Integer company_id;
  private Integer address_id;

  public Demo(int company_id, int address_id) {
    this.company_id = company_id;
    this.address_id = address_id;
  }

  public Demo() {
  }

  public Integer getCompany_id() {
    return company_id;
  }

  public  void setCompany_id(int company_id) {
    this.company_id = company_id;
  }

  public Integer getAddress_id() {
    return address_id;
  }

  public void setAddress_id(int address_id) {
    this.address_id = address_id;
  }
}
