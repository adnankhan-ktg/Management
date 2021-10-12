package com.management.api.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "question_id")
    private int id;
    private String question;

    @OneToMany(mappedBy = "question1",fetch = FetchType.EAGER)
    @JsonManagedReference("id")
    private List<Answer> answers;
}
