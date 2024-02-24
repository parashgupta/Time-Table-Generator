package com.demo.timetable.Repository;

import org.springframework.data.repository.CrudRepository;

import com.demo.timetable.Entity.Course;

public interface courseRepository extends CrudRepository<Course,Integer>
{
    
}