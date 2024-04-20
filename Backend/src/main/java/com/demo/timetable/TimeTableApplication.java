package com.demo.timetable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.demo.timetable.Entity.Course;
import com.demo.timetable.Service.CourseSemesterService;
import com.demo.timetable.Service.CourseTableService;
import com.demo.timetable.Service.CourseTableServiceImpl;
import com.demo.timetable.Service.TimeTableServiceImpl;

@SpringBootApplication
public class TimeTableApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(TimeTableApplication.class, args);
		System.out.println("Welcome to Spring Boot");
		

	}

}
