package com.demo.timetable.Service;

public interface SectionService {
    
    public void insertSectionName(String secName,Integer csid);
    public Boolean setSection(String courseName,String semester,String secName);
}