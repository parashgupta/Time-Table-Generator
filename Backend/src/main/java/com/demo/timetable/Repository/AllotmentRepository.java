package com.demo.timetable.Repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.timetable.Entity.Allotment;
@Repository
public interface AllotmentRepository extends CrudRepository<Allotment,Integer>{
 
    @Modifying
    @Query(value="INSERT INTO Allotment(fid_fk,sid_fk,csid_fk) values(:fid_fk, :sid_fk, :csid_fk)",nativeQuery = true)
    void allotFacultyToSubject(@Param("fid_fk") String fid_fk, @Param("sid_fk") String sid_fk, @Param("csid_fk") Integer csid_fk);
}