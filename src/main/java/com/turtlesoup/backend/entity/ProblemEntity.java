package com.turtlesoup.backend.entity;

import com.turtlesoup.backend.entity.enums.ProblemStatusEnum;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "problem")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
public class ProblemEntity extends BaseEntity{
    @Id
    @Column(name = "problem_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "problem_title")
    private String title;

    @Column(name = "problem_scenario")
    private String scenario;

    @Column(name = "problem_solution")
    private String solution;

    @Column(name = "problem_stats")
    private ProblemStatusEnum problemStatusEnum;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;
}
