package com.demo.timetable.Repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.timetable.Entity.Section;


@Repository
public interface SectionRepository extends CrudRepository<Section,Integer> {


    @Query("SELECT sec_id from Section WHERE sec_name= :secName and csid_f = :csid_f")
    public Integer findSectionId(@Param("secName") String secName,@Param("csid_f") Integer csid_f);

    @Query("SELECT sec_name FROM Section WHERE csid_f = :csid_f")
    public Iterable<Section> findSection(@Param("csid_f") Integer csid_f);

}