package com.example.faq_project.controller;

import com.example.faq_project.model.domain.AnnouncementModel;
import com.example.faq_project.service.AnnouncementService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/announcements")
public class AnnouncementController {

    private final AnnouncementService announcementService;

    // 모든 공지사항 조회
    @Operation(summary = "모든 공지사항 조회", description = "DB에 저장된 모든 공지사항 목록을 조회합니다.")
    @GetMapping
    public List<AnnouncementModel> findAll() {
        return announcementService.findAll();
    }

    // 특정 공지사항 조회
    @Operation(summary = "특정 공지사항 조회", description = "ID로 특정 공지사항을 조회합니다.")
    @GetMapping("/{id}")
    public Optional<AnnouncementModel> findById(@PathVariable Long id) {
        return announcementService.findById(id);
    }

    // 새로운 공지사항 추가
    @Operation(summary = "새로운 공지사항 추가", description = "새로운 공지사항을 추가합니다.")
    @PostMapping
    public AnnouncementModel addAnnouncement(@RequestBody AnnouncementModel announcementModel) {
        return announcementService.save(announcementModel);
    }

    // 공지사항 삭제
    @Operation(summary = "공지사항 삭제", description = "ID로 특정 공지사항을 삭제합니다.")
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        announcementService.deleteById(id);
    }
}

