package com.management.api.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Company {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;
  private String companyName;

  public Company(int id, String companyName) {
    this.id = id;
    this.companyName = companyName;
  }

  public Company() {
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getCompanyName() {
    return companyName;
  }

  public void setCompanyName(String companyName) {
    this.companyName = companyName;
  }

  @Override
  public String toString() {
    return "Company{" +
      "id=" + id +
      ", companyName='" + companyName + '\'' +
      '}';
  }
}
