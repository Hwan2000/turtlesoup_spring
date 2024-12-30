package com.turtlesoup.backend.repository;

import com.turtlesoup.backend.dto.problem.res.ProblemRes;
import com.turtlesoup.backend.entity.ProblemEntity;
import com.turtlesoup.backend.entity.enums.ProblemStatusEnum;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProblemRepository extends JpaRepository<ProblemEntity, UUID> {
    @Query("SELECT new com.turtlesoup.backend.dto.problem.res.ProblemRes(p.id, p.title, p.problemStatusEnum, p.createdAt, p.modifiedAt) FROM ProblemEntity p WHERE (p.title LIKE %:search% OR p.scenario LIKE %:search%) AND p.problemStatusEnum = :problemStatusEnum")
    Page<ProblemRes> readProblem(@Param("search") String search, @Param("problemStatusEnum") ProblemStatusEnum problemStatusEnum, Pageable pageable);
}
