package com.example.faq_project.model.domain;

import lombok.*;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Setter
@Getter
@Component //** 여기까지 알았음.이 클래스는 도메인 모델이여서 스프링 빈으로 등록할 필요가 없다고 함.
@Builder // 빌더 패턴으로 사용해서 객체를 유연하게 생성할 수 있음.
@ToString(exclude = "id")
@NoArgsConstructor
@AllArgsConstructor
public class QuestionModel {

    private Long id;

    private Long userId;

    private String title;  // 제목

    private String content; // 내용

    private Timestamp createdAt;

    private Timestamp updatedAt;


    /*@Builder // 빌더 애노테이션이 있어야 하는지는 모르겠음. 올알규스컨스트럭를 넣을 때 4개의 파라미터가 이미 존재한다고 해서 에러가 나와서 지웠음.
    public QuestionModel(Long id, String writer, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }*/
}
