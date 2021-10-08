package com.management.api.models;


import javax.persistence.*;

@Entity
public class Employee {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @PrimaryKeyJoinColumn
  private int id;
  private String firstName;
  private String lastName;
  private String age;

   @OneToOne(cascade = CascadeType.ALL)
   @JoinColumn(name="address_id",referencedColumnName = "id")
  private Address address;

   @ManyToOne(cascade = CascadeType.ALL)
   private Company company;

  public Employee() {
  }

  public Employee(int id, String firstName, String lastName, String age, Address address, Company company) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.age = age;
    this.address = address;
    this.company = company;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getAge() {
    return age;
  }

  public void setAge(String age) {
    this.age = age;
  }

  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }

  public Company getCompany() {
    return company;
  }

  public void setCompany(Company company) {
    this.company = company;
  }

  @Override
  public String toString() {
    return "Employee{" +
      "id=" + id +
      ", firstName='" + firstName + '\'' +
      ", lastName='" + lastName + '\'' +
      ", age='" + age + '\'' +
      ", address=" + address +
      ", company=" + company +
      '}';
  }
}
