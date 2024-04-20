package com.demo.timetable.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.demo.timetable.Entity.TimeTable;
import java.util.List;

public interface TimeTableRepository extends CrudRepository<TimeTable,Integer>{


  

}
