package com.example.faq_project.service.serviceimpl;

import com.example.faq_project.model.domain.QuestionModel;
import com.example.faq_project.model.entity.QuestionEntity;
import com.example.faq_project.model.repository.QuestionRepository;
import com.example.faq_project.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;

    // 엔티티를 모델로 변환하는 메서드
    private QuestionModel toModel(QuestionEntity entity) {
        return QuestionModel.builder()
                .id(entity.getId())
                .writer(entity.getWriter())
                .title(entity.getTitle())
                .contents(entity.getContents())
                .build();
    }

    // 모델을 엔티티로 변환하는 메서드
    private QuestionEntity toEntity(QuestionModel model) {
        return QuestionEntity.builder()
                .id(model.getId())
                .writer(model.getWriter())
                .title(model.getTitle())
                .contents(model.getContents())
                .build();
    }

    @Override
    public List<QuestionModel> findAll() {
        return questionRepository.findAll().stream()
                .map(this::toModel) // 엔티티를 모델로 변환
                .collect(Collectors.toList());
    }

    @Override
    public QuestionModel save(QuestionModel questionModel) {
        QuestionEntity savedEntity = questionRepository.save(toEntity(questionModel)); // 모델을 엔티티로 변환하여 저장
        return toModel(savedEntity); // 저장된 엔티티를 다시 모델로 변환하여 반환
    }

    @Override
    public Optional<QuestionModel> findById(Long id) {
        return questionRepository.findById(id)
                .map(this::toModel); // 엔티티를 모델로 변환하여 반환
    }

    @Override
    public void deleteById(Long id) {
        questionRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return questionRepository.existsById(id);
    }
}
