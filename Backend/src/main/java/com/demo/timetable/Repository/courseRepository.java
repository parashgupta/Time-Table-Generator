package com.demo.timetable.Repository;

import org.springframework.data.repository.CrudRepository;

import com.demo.timetable.Entity.Course;

public interface CourseRepository extends CrudRepository<Course,Integer>
{
    
}