package com.demo.timetable.Repository;

import org.springframework.data.repository.CrudRepository;

import com.demo.timetable.Entity.Allotment;

public interface AllotmentRepository extends CrudRepository<Allotment,Integer>{
    
}