package com.management.api.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

     @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
     @Column(name = "student_id")
      private int id;
     @Column(name = "student_name")
      private String studentName;

     @ManyToMany(cascade = CascadeType.ALL)
     private List<Project> projects;

}
