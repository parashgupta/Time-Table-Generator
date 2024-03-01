package com.demo.timetable.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.demo.timetable.Entity.SubMapping;

public interface SubMappingRepository extends CrudRepository<SubMapping,Integer> {
    
    @Query("SELECT s.sname FROM Subject s " +
            "JOIN SubMapping sm ON s.sid = sm.sid_f " +
            "JOIN CourseSemester cs ON cs.csid = sm.csid_f " +
            "JOIN Course c ON cs.cid_f = c.cid " +
            "WHERE c.cname = :courseName AND cs.semester = :semester")
    List<String> findSubjectByCourseAndSemester(@Param("courseName") String courseName,@Param("semester") String semester);
    
}