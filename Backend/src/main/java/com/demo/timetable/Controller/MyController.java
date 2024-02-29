package com.demo.timetable.Controller;

import org.springframework.web.bind.annotation.RestController;

import com.demo.timetable.Entity.Course;
import com.demo.timetable.Service.CourseService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;




@RestController
@RequestMapping("course")
@CrossOrigin(origins = "http://localhost:4200")
public class MyController {

    @Autowired
    private CourseService courseService;

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
    
}
