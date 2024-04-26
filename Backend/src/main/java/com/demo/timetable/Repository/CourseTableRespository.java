package com.demo.timetable.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.timetable.Entity.CourseTable;
@Repository
public interface CourseTableRespository extends CrudRepository<CourseTable,Integer>{

    @Query("SELECT tableid_pk FROM CourseTable WHERE csid_fk= :csid_fk and secid_fk= :secid_fk")
    public Integer findCourseTableId(@Param("csid_fk") Integer csid_fk,@Param("secid_fk") Integer secid_fk);

}
