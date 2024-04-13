package com.demo.timetable.Service;

import java.util.List;

import com.demo.timetable.Entity.CourseSemester;
import com.demo.timetable.Entity.TimeTable;

public interface CourseTableService {

    public void downloadExcel(String courseName,String semester);
    public Iterable<CourseSemester> finalTimeTable(String courseName,String semester,String secName);
}
