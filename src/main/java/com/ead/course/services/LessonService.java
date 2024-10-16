package com.ead.course.services;

import com.ead.course.models.LessonModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface LessonService{
    LessonModel save(LessonModel lessonModel);

    void delete(LessonModel lessonModel);

    Optional<LessonModel> findLessonIntoModule(UUID lessonId, UUID moduleId);

    List<LessonModel> findAllLessonsIntoModule(UUID lessonId);

    Page<LessonModel> findAllLessonsIntoModule(Specification<LessonModel> spec, Pageable pageable);
}
