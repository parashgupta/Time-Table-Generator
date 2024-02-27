package com.demo.timetable.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.timetable.Repository.CreditPRepository;

@Service
public class CreditPServiceImpl implements CreditPService {

    @Autowired
    private CreditPRepository creditPRepo;
    
}
