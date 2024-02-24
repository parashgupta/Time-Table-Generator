package com.demo.timetable.Service;

import com.demo.timetable.Entity.Course;

public interface CourseService
{
  public Course saveCourse(Course course);    
  public Iterable<Course> getAllCourse();
}