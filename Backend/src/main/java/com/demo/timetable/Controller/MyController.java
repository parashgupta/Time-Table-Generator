package com.demo.timetable.Controller;

import org.springframework.web.bind.annotation.RestController;

import com.demo.timetable.Entity.Course;
import com.demo.timetable.Service.CourseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;




@RestController
@RequestMapping("course")
public class MyController {
    
    @Autowired
    private CourseService courseService;

    @GetMapping("welcome")
    public String printout()
    {
        return "Jai Shree Ram";
    }

    @PostMapping("/save")
    public Course saveCourse(@RequestBody Course course)
    {
        return courseService.saveCourse(course);
    }
    @GetMapping
    public Iterable<Course> getAllCourse() {
        return courseService.getAllCourse();
    }
    
}
