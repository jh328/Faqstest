package com.example.faq_project.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@ToString
@Table(name = "questions")
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class QuestionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String writer; // 작성자
    private String title;  // 제목
    private String contents; // 내용


    public QuestionEntity(Long id, String writer, String title, String contents) {
        this.id = id;
        this.writer = writer;
        this.title = title;
        this.contents = contents;
    }
}
