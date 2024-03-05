package com.demo.timetable.Service;

import java.util.List;

import com.demo.timetable.Entity.Course;

public interface CourseService
{
  public Course saveCourse(Course course);    
  public Iterable<Course> getAllCourse();
  public List<String> getSemByCourse(String courseName);
    
}
