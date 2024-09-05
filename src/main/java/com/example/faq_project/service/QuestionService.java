package com.example.faq_project.service;

import com.example.faq_project.model.domain.QuestionModel;
import java.util.List;
import java.util.Optional;

public interface QuestionService {

    List<QuestionModel> findAll();

    // DTO(QuestionModel)를 받고 저장
    QuestionModel save(QuestionModel questionModel);

    Optional<QuestionModel> findById(Long id);

    void deleteById(Long id);

    boolean existsById(Long id);
}
