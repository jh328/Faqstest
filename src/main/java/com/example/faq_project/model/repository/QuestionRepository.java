package com.example.faq_project.model.repository;

import com.example.faq_project.model.domain.QuestionModel;
import com.example.faq_project.model.entity.QuestionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<QuestionEntity, Long> {

}
