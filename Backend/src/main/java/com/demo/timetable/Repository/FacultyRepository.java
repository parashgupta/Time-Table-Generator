package com.demo.timetable.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.timetable.Entity.Faculty;

@Repository
public interface FacultyRepository extends CrudRepository<Faculty,String>{

    @Query("SELECT f.fname FROM Faculty f WHERE f.fname LIKE %:name%")
    List<String> findFacultyNameByStartPattern(@Param(value = "name") String name);

    @Query("SELECT f.fid  FROM Faculty f WHERE f.fname= :facultyName")
    String findFidByFacultyName(@Param("facultyName") String facultyName);
}