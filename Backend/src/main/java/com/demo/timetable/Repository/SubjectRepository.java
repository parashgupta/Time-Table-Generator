package com.demo.timetable.Repository;

import org.springframework.data.repository.CrudRepository;

import com.demo.timetable.Entity.Subject;

public interface SubjectRepository extends CrudRepository<Subject,String> {
    
}