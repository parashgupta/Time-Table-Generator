package com.demo.timetable.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.timetable.Entity.CreditP;

@Repository
public interface CreditPRepository extends CrudRepository<CreditP,Integer>{
    
}