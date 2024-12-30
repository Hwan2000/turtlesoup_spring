package com.turtlesoup.backend.entity;

import com.turtlesoup.backend.entity.enums.QuestionAnswerEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.UUID;

@Entity
@Table(name = "question")
@Getter
@NoArgsConstructor
public class QuestionEntity extends BaseEntity{
    @Id
    @Column(name = "question_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "question_sentence")
    private String sentence;

    @Column(name ="question_answer")
    private QuestionAnswerEnum questionAnswerEnum;

    @Column(name = "question_isAnswer")
    private Boolean isAnswer;

    @ManyToOne
    @JoinColumn(name = "problem_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private ProblemEntity problemEntity;
}
