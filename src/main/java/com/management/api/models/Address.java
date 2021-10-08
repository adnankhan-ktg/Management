package com.management.api.models;


import javax.persistence.*;

@Entity
public class Address {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;
  private String cityName;
  private String zipCode;

  public Address(int id, String cityName, String zipCode) {
    this.id = id;
    this.cityName = cityName;
    this.zipCode = zipCode;
  }

  public Address() {
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getCityName() {
    return cityName;
  }

  public void setCityName(String cityName) {
    this.cityName = cityName;
  }

  public String getZipCode() {
    return zipCode;
  }

  public void setZipCode(String zipCode) {
    this.zipCode = zipCode;
  }
}


