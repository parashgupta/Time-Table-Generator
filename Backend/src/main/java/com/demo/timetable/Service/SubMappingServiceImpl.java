package com.demo.timetable.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.timetable.Repository.SubMappingRepository;

@Service
public class SubMappingServiceImpl implements SubMappingService {

    @Autowired
    private SubMappingRepository subMappingRepo;
    
}
