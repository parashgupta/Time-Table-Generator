package com.demo.timetable.Repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.demo.timetable.Entity.CourseSemester;


public interface CourseSemesterRepository extends CrudRepository<CourseSemester,Integer> {

    @Query("SELECT cs.csid  from CourseSemester cs JOIN Course c ON c.cid=cs.cid_f WHERE c.cname= :courseName and cs.semester= :semester")
    public Integer findCourseSemesterId(@Param("courseName") String courseName,@Param("semester") String semester);
    
    @Modifying
    @Query("UPDATE CourseSemester SET section=true WHERE csid= :csid ")
    public void updateSectionTrue(@Param("csid") Integer csid);

}