package com.demo.timetable.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.timetable.Entity.Course;
import com.demo.timetable.Repository.CourseRepository;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepo;

    @Override
    public Course saveCourse(Course course) {
        return courseRepo.save(course);
    }

    @Override
    public Iterable<Course> getAllCourse() {
       return courseRepo.findAll();
    }

    @Override
    public List<String> getSemByCourse(String courseName) {
        return courseRepo.findSemByCourse(courseName);
    }

    
    
}
