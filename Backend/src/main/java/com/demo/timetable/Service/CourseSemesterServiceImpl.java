package com.demo.timetable.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.timetable.Repository.CourseSemesterRepository;

@Service
public class CourseSemesterServiceImpl implements CourseSemesterService {

    @Autowired
    private CourseSemesterRepository courseSemesterRepo;

    // @Override
    // public List<String> getSubjectByCourseAndSemester(String courseName, String semester) {
        
    //     return courseSemesterRepo.findSubjectByCourseAndSemester(courseName,semester); 
    // }
    
}
