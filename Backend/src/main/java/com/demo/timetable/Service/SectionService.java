package com.demo.timetable.Service;

import java.util.List;

public interface SectionService {
    
    public void insertSectionName(String secName,Integer csid);
    public Boolean setSection(String courseName,String semester,String secName);
}