package com.example.faq_project.controller;

import com.example.faq_project.model.domain.QuestionModel;
import com.example.faq_project.service.QuestionService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/faqs") //faqs 들어가야 합니다.
@RequiredArgsConstructor
public class QuestionController {

    private final QuestionService questionService;

    // 모든 FAQ 질문을 조회
    @Operation(summary = "모든 질문 조회합니다.", description = "DB에 저장된 모든 질문 목록을 조회합니다.")
    @GetMapping
    public List<QuestionModel> findAll() {
        return questionService.findAll();
    }



    // 특정 FAQ 조회
    @Operation(summary = "특정 질문 조회", description = "ID로 특정 질문을 조회합니다.")
    @GetMapping("/{id}")
    public Optional<QuestionModel> findById(@PathVariable Long id) {  // id는 Long 타입으로 직접 처리
        return questionService.findById(id);
    }

    /**
     * 이거 남기는 이유는 공용 IP가 스트링 값으로 받기 때문에 파라미터에 스트링 값으로 받아야 할 수 있기 때문에 이 로직을 주석 처리 합니다.
     *
     * // 특정 FAQ 조회
     @Operation(summary = "특정 질문 조회합니다", description = "ID로 특정 질문을 조회합니다.")
     @GetMapping("/{id}")
     public Optional<QuestionModel> findById(@PathVariable String id) {
     // id가 숫자인 경우만 Long 타입으로 변환하여 처리
     try {
     Long questionId = Long.parseLong(id);
     return questionService.findById(questionId);
     } catch (NumberFormatException e) {
     // id가 숫자가 아니면 예외 처리 (예: IP 주소 등)
     return Optional.empty();
     }
     }*/


    // 새로운 질문을 추가
    @Operation(summary = "질문 추가.", description = "새로운 질문을 추가합니다.")
    @PostMapping
    public QuestionModel addQuestion(@RequestBody QuestionModel questionModel) {
        return questionService.save(questionModel);
    }



    // 질문 삭제
    @Operation(summary = "질문 삭제", description = "ID로 특정 질문을 삭제합니다.")
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {  // id는 Long 타입으로 직접 처리
        questionService.deleteById(id);
    }


   /* // 질문 삭제.
    @Operation(summary = "질문 삭제.", description = "ID로 특정 질문을 삭제합니다.")
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable String id) {
        try {
            Long questionId = Long.parseLong(id);
            questionService.deleteById(questionId);
        } catch (NumberFormatException e) {
            // id가 숫자가 아니면 처리 로직 (삭제할 수 없으므로 예외 처리를 할 수 있음)
        }
    }*/


    // 질문 존재 여부 확인
    @Operation(summary = "질문 존재 여부 확인", description = "ID로 특정 질문이 존재하는지 확인합니다.")
    @GetMapping("/exists/{id}")
    public boolean existsById(@PathVariable Long id) {  // id는 Long 타입으로 직접 처리
        return questionService.existsById(id);
    }

    /*@Operation(summary = "질문 존재 여부 확인. -송준한", description = "ID로 특정 질문이 존재하는지 확인합니다.")
    @GetMapping("/exists/{id}")
    public boolean existsById(@PathVariable String id) {
        try {
            Long questionId = Long.parseLong(id);
            return questionService.existsById(questionId);
        } catch (NumberFormatException e) {
            // id가 숫자가 아니면 false로 처리
            return false;
        }
    }*/


}
