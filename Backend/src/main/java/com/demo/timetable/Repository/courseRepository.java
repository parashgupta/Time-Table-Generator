package com.demo.timetable.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.timetable.Entity.Course;

@Repository
public interface CourseRepository extends CrudRepository<Course,Integer>
{
    @Query("SELECT cs.semester FROM CourseSemester cs JOIN Course c ON cs.cid_f = c.cid WHERE c.cname = :courseName")
    List<String> findSemByCourse(@Param("courseName") String courseName);

    
}
