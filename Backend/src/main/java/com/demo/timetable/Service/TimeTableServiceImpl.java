package com.demo.timetable.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class TimeTableServiceImpl implements TimeTableService {


    String[] day={"Monday","Tuesday","Wednusday","Thursday","Friday","Saturday"};
    
    Map<String,List<String>> monday=new HashMap<>();
    Map<String,List<String>> tuesday=new HashMap<>();
    Map<String,List<String>> wednusday=new HashMap<>();
    Map<String,List<String>> thursday=new HashMap<>();
    Map<String,List<String>> friday=new HashMap<>();
    Map<String,List<String>> saturday=new HashMap<>();


    {
        List<String> monday1=new ArrayList<>();
        monday1.add("M10");
        monday1.add("M11");
        monday1.add("M12");
        monday1.add("M1");
        monday1.add("M2");
        monday1.add("M3");
        monday.put("monday",monday1);

        List<String> tuesday1=new ArrayList<>();
        tuesday1.add("T10");
        tuesday1.add("T11");
        tuesday1.add("T12");
        tuesday1.add("T1");
        tuesday1.add("T2");
        tuesday1.add("T3");
        tuesday.put("tuesday", tuesday1);

        List<String> wednusday1=new ArrayList<>();
        wednusday1.add("W10");
        wednusday1.add("W11");
        wednusday1.add("W12");
        wednusday1.add("W1");
        wednusday1.add("W2");
        wednusday1.add("W3");
        wednusday.put("wednusday", wednusday1);

        List<String> thursday1=new ArrayList<>();
        thursday1.add("TH10");
        thursday1.add("TH11");
        thursday1.add("TH12");
        thursday1.add("TH1");
        thursday1.add("TH2");
        thursday1.add("TH3");
        thursday.put("thursday", thursday1);

        List<String> friday1=new ArrayList<>();
        friday1.add("F10");
        friday1.add("F11");
        friday1.add("F12");
        friday1.add("F1");
        friday1.add("F2");
        friday1.add("F3");
        friday.put("friday", friday1);

        List<String> saturday1=new ArrayList<>();
        saturday1.add("S10");
        saturday1.add("S11");
        saturday1.add("S12");
        saturday1.add("S1");
        saturday1.add("S2");
        saturday1.add("S3");
        saturday.put("saturday", saturday1);

    }
    public void generateTimeTable()
    {

    }

}
