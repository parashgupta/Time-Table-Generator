package com.demo.timetable.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.timetable.Repository.SectionRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Service
public class SectionServiceImpl implements SectionService {

    @Autowired
    private SectionRepository sectionRepo;

    @Autowired
    private CourseSemesterServiceImpl courseSemesterService;
   
    // @Autowired
    // private CourseService courseService;

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public Boolean setSection(String courseName,String semester,String secName){
        Integer csId=courseSemesterService.getCourseSemesterId(courseName,semester);
        insertSectionName(secName, csId);
        courseSemesterService.updateSection(csId);
        System.out.println("I am a leader"+csId);
        return true;
    }

    @Override
    public void insertSectionName(String secName, Integer csid) {
        // TODO Auto-generated method stub
        sectionRepo.setSectionName(secName,csid);
        
    }

    

    
}
