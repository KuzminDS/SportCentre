package com.ssu.Kuzmin.SportCentre.service;

import com.ssu.Kuzmin.SportCentre.dao.LessonDao;
import com.ssu.Kuzmin.SportCentre.entity.Gym;
import com.ssu.Kuzmin.SportCentre.entity.Lesson;

import java.util.List;

public class LessonService {

    private final LessonDao lessonDao;

    public LessonService(LessonDao lessonDao) {
        this.lessonDao = lessonDao;
    }

    public Lesson getById(int id) throws Exception {
        return lessonDao.getById(id);
    }

    public List<Lesson> getAll() {
        return lessonDao.getAll();
    }

    public void add(Lesson lesson) {
        lessonDao.add(lesson);
    }

    public void update(Lesson lesson) {
        lessonDao.update(lesson);
    }

    public void delete(Lesson lesson) {
        lessonDao.delete(lesson);
    }
}
