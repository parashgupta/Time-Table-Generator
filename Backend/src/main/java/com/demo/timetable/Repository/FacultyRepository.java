package com.demo.timetable.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.demo.timetable.Entity.Faculty;

public interface FacultyRepository extends CrudRepository<Faculty,String>{

    @Query("SELECT f.fname FROM Faculty f WHERE f.fname LIKE %:name%")
    List<String> findFacultyNameByStartPattern(@Param(value = "name") String name);
}