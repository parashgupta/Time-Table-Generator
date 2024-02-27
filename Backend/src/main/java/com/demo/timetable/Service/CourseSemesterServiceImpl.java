package com.demo.timetable.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.timetable.Repository.CourseSemesterRepository;

@Service
public class CourseSemesterServiceImpl implements CourseSemesterService {

    @Autowired
    private CourseSemesterRepository courseSemesterRepo;
    
}
