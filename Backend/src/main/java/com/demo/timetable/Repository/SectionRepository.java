package com.demo.timetable.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.demo.timetable.Entity.Section;


public interface SectionRepository extends CrudRepository<Section,Integer> {

    
    @Modifying
    @Query(value="INSERT into Section(sec_name,csid_f) values(:secName,:csid)",nativeQuery = true)
    void setSectionName(@Param("secName") String secName,@Param("csid") Integer csid);

}