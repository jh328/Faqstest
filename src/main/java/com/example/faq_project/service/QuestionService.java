package com.example.faq_project.service;

import com.example.faq_project.model.domain.QuestionModel;
import java.util.List;
import java.util.Optional;

public interface QuestionService {

    // 모든 FAQ 조회.
    List<QuestionModel> findAll();

    // DTO(QuestionModel)를 받고 저장
    // 새로운 FAQ 추가.
    QuestionModel save(QuestionModel questionModel);

    // 특정 FAQ 조회.
    Optional<QuestionModel> findById(Long id);

    // FAQ 삭제
    void deleteById(Long id);

    // FAQ 존재 여부 확인
    boolean existsById(Long id);
}
