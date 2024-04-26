package com.demo.timetable.Service;

import java.util.List;
import java.util.Map;

import com.demo.timetable.Entity.CourseSemester;
import com.demo.timetable.Entity.TimeTable;

public interface CourseTableService {

    public Boolean downloadExcel(String courseName, String semester, String secName);
    public Iterable<TimeTable> finalTimeTable(String courseName,String semester,String secName);
    public void setCourseTable(String courseName, String semester, String secName,Map<String,String> subjectWithFaculty);

}
