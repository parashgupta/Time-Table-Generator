package com.demo.timetable.Repository;

import org.springframework.data.repository.CrudRepository;

import com.demo.timetable.Entity.Section;

public interface SectionRepository extends CrudRepository<Section,Integer> {
    
}