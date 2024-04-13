package com.demo.timetable.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.demo.timetable.Entity.TimeTable;
import java.util.List;

public interface TimeTableRepository extends CrudRepository<TimeTable,Integer>{

    // @Query("select day as DAY,'10' as '10:00-11:00','11' as '11:00-12:00','12' as '12:00-1:00','1' as '1:00-2:00','2' as '2:00-3:00','3' as '3:00-4:00' from timtable where tableid_fk=:tableid_fk")
    // public List finalTimeTable(@Param("tableid_fk") Integer tableid_fk);
}
