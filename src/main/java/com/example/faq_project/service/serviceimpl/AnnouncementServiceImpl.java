package com.example.faq_project.service.serviceimpl;

import com.example.faq_project.model.domain.AnnouncementModel;
import com.example.faq_project.model.entity.AnnouncementEntity;
import com.example.faq_project.model.repository.AnnouncementRepository;
import com.example.faq_project.service.AnnouncementService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class AnnouncementServiceImpl implements AnnouncementService {

    private final AnnouncementRepository announcementRepository;

    // 엔티티를 모델로 변환하는 메소드
    private AnnouncementModel toModel(AnnouncementEntity entity) {
        return AnnouncementModel.builder()
                .id(entity.getId()) // 공지사항 아이디
                .userId(entity.getUserId()) // 작성자 아이디
                .title(entity.getTitle())
                .content(entity.getContent())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .build();
    }


    // Model을 Entity로 변환하는 메서드
    private AnnouncementEntity toEntity(AnnouncementModel model) {
        return AnnouncementEntity.builder()
                .id(model.getId())
                .userId(model.getUserId())
                .title(model.getTitle())
                .content(model.getContent())
                .createdAt(model.getCreatedAt())
                .updatedAt(model.getUpdatedAt())
                .build();
    }

    @Override
    public List<AnnouncementModel> findAll() {
        return announcementRepository.findAll().stream()  // 엔티티 리스트를 스트림으로 변환
                .map(this::toModel)  // 각 엔티티를 모델로 변환
                .collect(Collectors.toList());  // 결과를 리스트로 수집하여 반환
    }

    @Override
    public AnnouncementModel save(AnnouncementModel announcementModel) {
        AnnouncementEntity savedEntity = announcementRepository.save(toEntity(announcementModel));
        return toModel(savedEntity);
    }

    @Override
    public Optional<AnnouncementModel> findById(Long id) {
        return announcementRepository.findById(id).map(this::toModel);
    }

    @Override
    public void deleteById(Long id) {
        announcementRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return announcementRepository.existsById(id);
    }



}
