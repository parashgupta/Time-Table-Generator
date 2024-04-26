package com.demo.timetable.Service;

import com.demo.timetable.Entity.Section;

public interface SectionService {
    
    public Boolean setSection(String courseName,String semester,String secName);
    public Iterable<Section> getAllSection(String courseName,String semester);
}