package com.turtlesoup.backend.dto.problem.req;

import lombok.Data;

@Data
public class ProblemCreateReq {
    private String title;
    private String scenario;
}
