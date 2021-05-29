package com.ssu.Kuzmin.SportCentre.service;

import com.ssu.Kuzmin.SportCentre.dao.LessonDao;
import com.ssu.Kuzmin.SportCentre.entity.Gym;
import com.ssu.Kuzmin.SportCentre.entity.Lesson;

import java.util.List;

public class LessonService extends Service<Lesson> {
    public LessonService() {
        super(Lesson.class);
    }
}
