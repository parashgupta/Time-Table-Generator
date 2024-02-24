package com.demo.timetable.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.timetable.Entity.Course;
import com.demo.timetable.Repository.courseRepository;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private courseRepository courseRepo;

    @Override
    public Course saveCourse(Course course) {
        return courseRepo.save(course);
    }

    @Override
    public Iterable<Course> getAllCourse() {
       return courseRepo.findAll();
    }
    
}