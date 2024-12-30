package com.turtlesoup.backend.controller;

import com.turtlesoup.backend.config.security.PrincipalDetails;
import com.turtlesoup.backend.dto.problem.req.ProblemCreateReq;
import com.turtlesoup.backend.dto.problem.res.ProblemRes;
import com.turtlesoup.backend.service.ProblemService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/problem")
public class ProblemController {
    private final ProblemService problemService;

    @GetMapping()
    public String problem(@RequestParam(required = false) String search,
                          @RequestParam(defaultValue = "SOLVED") String status,
                          @PageableDefault(size = 20, sort = "createdAt", direction = Sort.Direction.ASC) Pageable pageable,
                          Model model,
                          HttpServletRequest httpServletRequest){

        Page<ProblemRes> problemResPage = problemService.readProblem(search, status, pageable);

        int blockLimit = 3;
        int startPage = (((int) Math.ceil(((double) pageable.getPageNumber() / blockLimit))) - 1) * blockLimit + 1;
        int endPage = Math.min((startPage + blockLimit - 1), problemResPage.getTotalPages());

        model.addAttribute("request", httpServletRequest);
        model.addAttribute("number", problemResPage.getNumber());
        model.addAttribute("totalPages", problemResPage.getTotalPages());
        model.addAttribute("problemResPage", problemResPage);
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);
        model.addAttribute("problemResPage", problemResPage);

        return "problem/problem";
    }

    @GetMapping("/{id}")
    public String problemById(@PathVariable String id, Model model){
        // solved 면 풀린 화면 리턴
        // solved 아니면서 출제자 아니면 안풀린 화면 리턴
        // solved 아니면서 출제자면 정답체크 화면 리턴
        
        return null;
    }

    @GetMapping("/create")
    public String problemCreate(Model model) {
        model.addAttribute("ProblemCreateReq", new ProblemCreateReq());
        return "problem/create";
    }

    @PostMapping("/create")
    public String problemCreate(@ModelAttribute ProblemCreateReq problemCreateReq,
                                @AuthenticationPrincipal PrincipalDetails principalDetails){
        problemService.createProblem(problemCreateReq);
        //todo 추후 redirect:/problem/problem 으로 변경
        return "redirect:/home";
    }
}
