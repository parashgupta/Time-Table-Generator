package com.demo.timetable.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.timetable.Repository.FacultyRepository;

@Service
public class FacultyServiceImpl implements FacultyService {

    @Autowired
    private FacultyRepository facultyRepo;

    @Override
    public List<String> getFacultyNameByStartPattern(String name) {
        return facultyRepo.findFacultyNameByStartPattern(name);
    }

    @Override
    public String getfidByFaculty(String facultyName) {
        // TODO Auto-generated method stub
        return facultyRepo.findFidByFacultyName(facultyName);
    }

    
}
