package com.demo.timetable.Service;

import java.util.List;

import com.demo.timetable.Entity.CourseSemester;
import com.demo.timetable.Entity.TimeTable;

public interface CourseTableService {

    public void downloadExcel(String courseName,String semester);
    public Iterable<TimeTable> finalTimeTable(String courseName,String semester,String secName);
    public void setCourseTable(String courseName, String semester, String secName);

}
