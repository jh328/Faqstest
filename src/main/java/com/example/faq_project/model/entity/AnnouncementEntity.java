package com.example.faq_project.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "announcements")
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)

public class AnnouncementEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    private String title;

    private String content;

    private Timestamp createdAt; // 2.이 필드에 현재 시간을 기록하기 위해 new Times~~ 이 메서드를 사용하는하는거다.

    private Timestamp updatedAt;

    // 엔티티 저장 전 시간 자동 설정 (JPA 이벤트)
    @PrePersist
    protected void onCreate() {
        this.createdAt = new Timestamp(System.currentTimeMillis());
        // 1. new Times~~~ 현재 시간을 생성일자로 설정 해주는 로직\
        // 3. new ~~ 현재 시간을 밀리초 단위로 반환하는 메서드. 이를 Timestamp 객체로 변환하기 위해 new~~를 사용
        // 4. 이 코드를 사용하면 엔티티가 데이터베이스에 처음 삽입될 때마다, 해당 엔티티의
        // createdAt 필드가 자동으로 현재 시간으로 설정이 된다.  송준한 이해 -v
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = new Timestamp(System.currentTimeMillis());
    }

}
