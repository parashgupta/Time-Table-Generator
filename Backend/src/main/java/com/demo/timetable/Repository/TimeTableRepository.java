package com.demo.timetable.Repository;

import org.springframework.data.repository.CrudRepository;

import com.demo.timetable.Entity.TimeTable;
public interface TimeTableRepository extends CrudRepository<TimeTable,Integer>{

}
