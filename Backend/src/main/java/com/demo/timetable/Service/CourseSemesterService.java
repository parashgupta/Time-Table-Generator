package com.demo.timetable.Service;


public interface CourseSemesterService {

    public Integer getCourseSemesterId(String coursename,String semester);
    public void updateSection(Integer csid);
    public Boolean checkSection(String coursename,String semester);
    
}