package com.example.faq_project.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@ToString
@Table(name = "faqs")
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@AllArgsConstructor

public class QuestionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // false로 선언을 해서, 값이 반드시 존재 해야 필드로 동작을 한다.
    // NULL을 허용하지 않는다는 뜻이다.
    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "content", nullable = false, columnDefinition = "LONGTEXT")
    private String content;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}

