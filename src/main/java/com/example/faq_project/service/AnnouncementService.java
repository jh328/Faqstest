package com.example.faq_project.service;

import com.example.faq_project.model.domain.AnnouncementModel;

import java.util.List;
import java.util.Optional;

public interface AnnouncementService {

    // 모든 공지사항을 조회
    List<AnnouncementModel> findAll();

    // 공지사항 추가 또는 수정
    AnnouncementModel save(AnnouncementModel announcementModel);

    // 조회
    Optional<AnnouncementModel> findById(Long id);

    // 삭제
    void deleteById(Long id);

    // 공지사항 있는지 확인
    boolean existsById(Long id);

}
