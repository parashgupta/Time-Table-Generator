package com.demo.timetable.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.timetable.Repository.AllotmentRepository;

@Service
public class AllotmentServiceImpl implements AllotmentService {

    @Autowired
    private AllotmentRepository allotmentRepo;
    
}


