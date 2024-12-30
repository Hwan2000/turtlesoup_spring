package com.turtlesoup.backend.dto.problem.res;

import com.turtlesoup.backend.entity.enums.ProblemStatusEnum;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class ProblemRes {
    private String id;
    private String title;
    private String problemStatusEnum;
    private String createdAt;
    private String modifiedAt;

    public ProblemRes(UUID id, String title, ProblemStatusEnum problemStatusEnum, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.id = id.toString();
        this.title = title;
        this.problemStatusEnum = problemStatusEnum.name();
        this.createdAt = createdAt.toLocalDate().toString();
        this.modifiedAt = modifiedAt.toLocalDate().toString();
    }
}
