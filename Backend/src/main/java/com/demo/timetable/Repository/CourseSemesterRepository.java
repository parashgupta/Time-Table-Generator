package com.demo.timetable.Repository;

import org.springframework.data.repository.CrudRepository;

import com.demo.timetable.Entity.CourseSemester;

public interface CourseSemesterRepository extends CrudRepository<CourseSemester,Integer> {
    
}