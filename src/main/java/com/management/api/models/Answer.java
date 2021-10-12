package com.management.api.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "answer_id")
    private int id;
    private String answer;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "question_id")
    @JsonBackReference("id")
    private Question question1;
}
