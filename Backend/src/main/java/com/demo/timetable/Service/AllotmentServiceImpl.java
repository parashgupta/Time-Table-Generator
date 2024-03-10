package com.demo.timetable.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.timetable.Repository.AllotmentRepository;

import jakarta.transaction.Transactional;

@Service
public class AllotmentServiceImpl implements AllotmentService {

    @Autowired
    private AllotmentRepository allotmentRepo;

    @Autowired
    private CourseSemesterServiceImpl courseSemesterService;
    @Autowired
    private SubjectService subjectService;
    @Autowired
    private FacultyService facultyService;

    @Transactional
    @Override
    public Boolean allotFaculty(String courseName, String semester, String subject, String faculty) {
        // return allotmentRepo.allotFaculty(courseName,semester,subject,faculty);
        Integer csid_fk=courseSemesterService.getCourseSemesterId(courseName,semester);
        String sid_fk =subjectService.getSidBySubject(subject);
        String fid_fk = facultyService.getfidByFaculty(faculty);
        // System.out.println("I am the leader and this is my csId "+csid_fk);
        // System.out.println("I am the leader and this is my sid "+sid_fk);
        // System.out.println("I am the leader and this is my fid "+fid_fk);
        allotmentRepo.allotFacultyToSubject(fid_fk,sid_fk,csid_fk);

        return true;
    }
    
}


