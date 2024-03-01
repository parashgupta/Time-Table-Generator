package com.demo.timetable.Service;

import java.util.List;

public interface SubMappingService {
    
        List<String> getSubjectByCourseAndSemester(String courseName, String semester);

}