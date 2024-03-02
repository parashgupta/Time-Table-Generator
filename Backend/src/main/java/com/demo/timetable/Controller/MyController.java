package com.demo.timetable.Controller;

import org.springframework.web.bind.annotation.RestController;

import com.demo.timetable.Entity.Course;
import com.demo.timetable.Entity.Faculty;
import com.demo.timetable.Service.CourseSemesterService;
import com.demo.timetable.Service.CourseService;
import com.demo.timetable.Service.FacultyService;
import com.demo.timetable.Service.SubMappingService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;




@RestController
@RequestMapping("course")
@CrossOrigin(origins = "http://localhost:4200")
public class MyController {

    @Autowired
    private CourseService courseService;
    @Autowired
    private SubMappingService subMappingService;
    @Autowired
    private FacultyService facultysService;

    @GetMapping("welcome")
    public String printout()
    {
        return "Jai Shree Ram";
    }

    //get All Courses
    @GetMapping
    public Iterable<Course> getAllCourse() {
        return courseService.getAllCourse();
    }
    
    //get semester by course
    //http://localhost:8080/course/courseName?courseName=BCA
    @GetMapping("/courseName")
    public List<String> getSemByCourse(@RequestParam(defaultValue = "defaultCourse") String courseName) {
        return courseService.getSemByCourse(courseName);
    }

    //get subject by coursename and semester
    @GetMapping("/subject")
    public List<String> getSubjectByCourseAndSemester(@RequestParam(defaultValue = "defaultCourse") String courseName, @RequestParam String semester) {
        return subMappingService.getSubjectByCourseAndSemester(courseName,semester);
    }

    @GetMapping("/name")
    public List<String> getFacultyNameByStartPattern(@RequestParam String name) {
        return facultysService.getFacultyNameByStartPattern(name);
    }
    
    
}
