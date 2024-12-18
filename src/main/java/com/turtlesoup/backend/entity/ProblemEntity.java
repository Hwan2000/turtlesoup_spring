package com.turtlesoup.backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "question")
@Getter
@NoArgsConstructor
public class ProblemEntity extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "problem_scenario")
    private String scenario;

    @Column(name = "problem_solution")
    private String solution;
}
