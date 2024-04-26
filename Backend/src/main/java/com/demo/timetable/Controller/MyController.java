package com.demo.timetable.Controller;

import org.springframework.web.bind.annotation.RestController;

import com.demo.timetable.Entity.Course;
import com.demo.timetable.Entity.CourseSemester;
import com.demo.timetable.Entity.Section;
import com.demo.timetable.Entity.TimeTable;
import com.demo.timetable.Service.AllotmentService;
import com.demo.timetable.Service.CourseSemesterService;
import com.demo.timetable.Service.CourseService;
import com.demo.timetable.Service.CourseTableService;
import com.demo.timetable.Service.FacultyService;
import com.demo.timetable.Service.SectionService;
import com.demo.timetable.Service.SubMappingService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @Autowired
    private SubMappingService subMappingService;
    @Autowired
    private FacultyService facultysService;
    @Autowired
    private SectionService sectionService;
    @Autowired
    private AllotmentService allotmentService;
    @Autowired
    private CourseTableService courseTableService;
    @Autowired
    private CourseSemesterService courseSemesterService;

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
    @GetMapping("/allsection")
    public Iterable<Section> getAllSection() {
        return sectionService.getAllSection();
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
    
    //faculty list by name
    @GetMapping("/name")
    public List<String> getFacultyNameByStartPattern(@RequestParam String name) {
        return facultysService.getFacultyNameByStartPattern(name);
    }

    @GetMapping("/section")
    public Boolean setSection(@RequestParam String courseName,@RequestParam String semester,@RequestParam String secName) {
        return sectionService.setSection(courseName,semester,secName);
    }

    @GetMapping("/checksection")
    public Boolean checkSection(@RequestParam String courseName,@RequestParam String semester) {
        return courseSemesterService.checkSection(courseName,semester);
    }
    
    @GetMapping("/allotment")
    public Boolean allotFaculty(@RequestParam String courseName, @RequestParam String semester, @RequestParam String subject, @RequestParam String faculty) {        
    return allotmentService.allotFaculty(courseName, semester, subject, faculty);
}

@GetMapping("/download")
    public void downloadExcel(@RequestParam String courseName, @RequestParam String semester,@RequestParam(value = "secName", required = false) String secName) {        
     courseTableService.downloadExcel(courseName, semester,secName);  
}

@GetMapping("/showtimetable")
    public Iterable<TimeTable> finalTimeTable(@RequestParam String courseName, @RequestParam String semester,@RequestParam(value = "secName", required = false) String secName) {        
     return courseTableService.finalTimeTable(courseName, semester,secName);  
}

@PostMapping("/test")
public void setCourseTable(@RequestBody Map<String, Object> subjectWithFaculty) {

    try {
        System.out.println("Received request with data =============> " + subjectWithFaculty);
        String courseName = (String) subjectWithFaculty.get("courseName");
        String semester = (String) subjectWithFaculty.get("semester");
        String section = (String) subjectWithFaculty.get("section");
        Map<String, Object> data = (Map<String, Object>) subjectWithFaculty.get("subjectWithFaculty");
        Map<String, String> data1 = new HashMap<>();

        for (Map.Entry<String, Object> entry : data.entrySet()) {
        String key = entry.getKey();
        Object value = entry.getValue();

    
        String stringValue = String.valueOf(value); // Handles null values gracefully

    
        data1.put(key, stringValue);
}

        // Now you can use courseName, semester, and subjectWithFaculty as needed
        System.out.println("Course Name: " + courseName);
        System.out.println("Semester: " + semester);
        System.out.println("section: " + section);
        System.out.println("Subject with Faculty:");
        for (Map.Entry<String, Object> entry : data.entrySet()) {
            System.out.println("Subject: " + entry.getKey() + ", Faculty: " + entry.getValue());
        }
        courseTableService.setCourseTable(courseName, semester , section,data1);  

    } catch (Exception e) {
        System.err.println("Error processing request: " + e.getMessage());
        e.printStackTrace();
    }
}
}