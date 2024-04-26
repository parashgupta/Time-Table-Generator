package com.demo.timetable.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.timetable.Entity.TimeTable;
import java.util.List;

@Repository
public interface TimeTableRepository extends CrudRepository<TimeTable,Integer>{

    @Query("SELECT day,ten,eleven,twelve,one,two,three FROM TimeTable WHERE tableid_fk = :tableid_fk")
    Iterable<TimeTable> findAllByTableId(@Param("tableid_fk") Integer tableid_fk);


  

}
