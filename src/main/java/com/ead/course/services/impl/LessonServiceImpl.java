package com.ead.course.services.impl;

import com.ead.course.models.LessonModel;
import com.ead.course.repositories.LessonRepository;
import com.ead.course.services.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class LessonServiceImpl implements LessonService {

    @Autowired
    private LessonRepository lessonRepository;

    @Override
    public LessonModel save(LessonModel lessonModel) {
        return lessonRepository.save(lessonModel);
    }


    @Override
    public void delete(LessonModel lessonModel) {

        lessonRepository.delete(lessonModel);
    }

    @Override
    public Optional<LessonModel> findLessonIntoModule(UUID lessonId, UUID moduleId) {
        return lessonRepository.findLessonIntoModule(lessonId, moduleId);
    }

    @Override
    public List<LessonModel> findAllLessonsIntoModule(UUID lessonId) {
        return lessonRepository.findAllLessonsIntoModule(lessonId);
    }
}
