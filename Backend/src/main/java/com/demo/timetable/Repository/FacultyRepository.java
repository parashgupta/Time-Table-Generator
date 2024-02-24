package com.demo.timetable.Repository;

import org.springframework.data.repository.CrudRepository;

import com.demo.timetable.Entity.Faculty;

public interface FacultyRepository extends CrudRepository<Faculty,String>{
    
}