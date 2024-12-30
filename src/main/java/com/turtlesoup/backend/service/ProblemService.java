package com.turtlesoup.backend.service;

import com.turtlesoup.backend.dto.problem.req.ProblemCreateReq;
import com.turtlesoup.backend.dto.problem.res.ProblemRes;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface ProblemService {
    Page<ProblemRes> readProblem(String search, String status, Pageable pageable);
    void createProblem(ProblemCreateReq problemCreateReq);
}
