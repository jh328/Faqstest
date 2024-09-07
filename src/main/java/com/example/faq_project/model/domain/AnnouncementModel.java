package com.example.faq_project.model.domain;

import lombok.*;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Setter
@Getter
@Builder
@ToString(exclude = "id")
@NoArgsConstructor
@AllArgsConstructor
public class AnnouncementModel {

    private Long id;
    private Long userId;

    private String title;
    private String content;

    private Timestamp createdAt;
    private Timestamp updatedAt;

}
