package com.demo.timetable.Service;

import java.util.Map;

public interface TimeTableService {

    public String generateTimeTables(Integer tableid,Map<String,String> subjectWithFaculty,Integer csid_fk);

}
