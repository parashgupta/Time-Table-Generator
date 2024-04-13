package com.demo.timetable.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.timetable.Repository.CourseSemesterRepository;

@Service
public class CourseSemesterServiceImpl implements CourseSemesterService {

    @Autowired
    private CourseSemesterRepository courseSemesterRepo;

    @Override
    public Integer getCourseSemesterId(String courseName,String semester) {
        return courseSemesterRepo.findCourseSemesterId(courseName,semester);
    }

    @Override
    public void updateSection(Integer csid) {
        // TODO Auto-generated method stub
        courseSemesterRepo.updateSectionTrue(csid);
    }

    @Override
    public Boolean checkSection(String coursename, String semester) {
        // TODO Auto-generated method stub
        Integer csid = courseSemesterRepo.findCourseSemesterId(coursename,semester);
        return courseSemesterRepo.checkSection(csid);
    }

   
    
}
