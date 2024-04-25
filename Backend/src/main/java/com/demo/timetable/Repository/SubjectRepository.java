package com.demo.timetable.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.timetable.Entity.Subject;

@Repository
public interface SubjectRepository extends CrudRepository<Subject,String> {

    @Query("SELECT s.sid  FROM Subject s WHERE s.sname= :subject")
    String findSidBySubject(@Param("subject") String subject);

}