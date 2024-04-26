package com.demo.timetable.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.timetable.Entity.Section;
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


    @Transactional
    @Override
    public Boolean setSection(String courseName,String semester,String secName){
        System.out.println("=====================>"+courseName);
        System.out.println("=====================>"+semester);
        System.out.println("=====================>"+secName);
        
        Integer csId=courseSemesterService.getCourseSemesterId(courseName,semester);
        System.out.println("=====================>"+csId);

        Section section=new Section();
        section.setCsid_f(csId);
        section.setSec_name(secName);
        Section section2=sectionRepo.save(section);
        System.out.println(section2);
        courseSemesterService.updateSection(csId);
        return true;
    }

    @Override
    public Iterable<Section> getAllSection(String course,String semester) {
        Integer csId=courseSemesterService.getCourseSemesterId(course,semester);
        return sectionRepo.findSection(csId);
    }

    

    
}
