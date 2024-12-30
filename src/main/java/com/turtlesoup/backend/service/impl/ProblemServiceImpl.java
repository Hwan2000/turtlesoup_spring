package com.turtlesoup.backend.service.impl;

import com.turtlesoup.backend.config.security.PrincipalDetails;
import com.turtlesoup.backend.dto.problem.req.ProblemCreateReq;
import com.turtlesoup.backend.dto.problem.res.ProblemRes;
import com.turtlesoup.backend.entity.ProblemEntity;
import com.turtlesoup.backend.entity.UserEntity;
import com.turtlesoup.backend.entity.enums.ProblemStatusEnum;
import com.turtlesoup.backend.repository.ProblemRepository;
import com.turtlesoup.backend.repository.UserRepository;
import com.turtlesoup.backend.service.ProblemService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;

@Service
@RequiredArgsConstructor
public class ProblemServiceImpl implements ProblemService {

    private final ProblemRepository problemRepository;
    private final UserRepository userRepository;

    @Override
    public Page<ProblemRes> readProblem(String search, String status, Pageable pageable) {
        return problemRepository.readProblem(search, ProblemStatusEnum.valueOf(status), pageable);
    }

    /**
     *
     * @param problemCreateReq
     */
    @Override
    @Transactional
    public void createProblem(ProblemCreateReq problemCreateReq) {
        PrincipalDetails principalDetails = (PrincipalDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        UserEntity userEntity = userRepository.findById(principalDetails.getUserId()).orElseThrow(
                () -> new RuntimeException("No user: " + principalDetails.getUserId().toString())
        );

        ProblemEntity problemEntity = ProblemEntity.builder()
                .scenario(problemCreateReq.getScenario())
                .title(problemCreateReq.getTitle())
                .userEntity(userEntity)
                .problemStatusEnum(ProblemStatusEnum.ONGOING)
                .build();

        problemRepository.save(problemEntity);
    }
}
