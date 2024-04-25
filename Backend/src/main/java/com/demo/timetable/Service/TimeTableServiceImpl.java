package com.demo.timetable.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.timetable.Entity.Allotment;
import com.demo.timetable.Entity.TimeTable;
import com.demo.timetable.Repository.AllotmentRepository;
import com.demo.timetable.Repository.FacultyRepository;
import com.demo.timetable.Repository.SubjectRepository;
import com.demo.timetable.Repository.TimeTableRepository;

@Service
public class TimeTableServiceImpl implements TimeTableService {


    @Autowired
    private TimeTableRepository timeTableRepository;
    @Autowired
    private AllotmentRepository allotmentRepository;
    @Autowired
    private FacultyRepository facultyRepository;
    @Autowired
    private SubjectRepository subjectRepository;
  
    String[] day={"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
    
    Map<String,List<String>> monday=new HashMap<>();
    Map<String,List<String>> tuesday=new HashMap<>();
    Map<String,List<String>> wednesday=new HashMap<>();
    Map<String,List<String>> thursday=new HashMap<>();
    Map<String,List<String>> friday=new HashMap<>();
    Map<String,List<String>> saturday=new HashMap<>();


    
        List<String> monday1=new ArrayList<>();
        List<String> tuesday1=new ArrayList<>();
        List<String> wednusday1=new ArrayList<>();
        List<String> thursday1=new ArrayList<>();
        List<String> friday1=new ArrayList<>();
        List<String> saturday1=new ArrayList<>();
{
        monday1.add("M10");
        monday1.add("M11");
        monday1.add("M12");
        monday1.add("M2");
        monday1.add("M3");
        monday.put("monday",monday1);

        tuesday1.add("T10");
        tuesday1.add("T11");
        tuesday1.add("T12");
        tuesday1.add("T2");
        tuesday1.add("T3");
        tuesday.put("tuesday", tuesday1);

        wednusday1.add("W10");
        wednusday1.add("W11");
        wednusday1.add("W12");
        wednusday1.add("W2");
        wednusday1.add("W3");
        wednesday.put("wednusday", wednusday1);

        thursday1.add("TH10");
        thursday1.add("TH11");
        thursday1.add("TH12");
        thursday1.add("TH2");
        thursday1.add("TH3");
        thursday.put("thursday", thursday1);

        friday1.add("F10");
        friday1.add("F11");
        friday1.add("F12");
        friday1.add("F2");
        friday1.add("F3");
        friday.put("friday", friday1);

        saturday1.add("S10");
        saturday1.add("S11");
        saturday1.add("S12");
        saturday1.add("S2");
        saturday1.add("S3");
        saturday.put("saturday", saturday1);

}   
public boolean isAllotmentTableEmpty() {
    long count = allotmentRepository.count();
    return count == 0;
}
   
    public String generateTimeTables(Integer tableid,Map<String,String> subjectWithFaculty,Integer csid_fk) {
       
        List<String> keysList = new ArrayList<>(subjectWithFaculty.keySet());
        List<String> valuesList = new ArrayList<>(subjectWithFaculty.values());
        for(String day1:day)
        {
            
            TimeTable timeTable=new TimeTable();
            timeTable.setTableid_fk(tableid);
            timeTable.setDay(day1);
            System.out.println("before if");

            if(isAllotmentTableEmpty())
            {
                System.out.println("after if");
                timeTable.setTen(keysList.get(0)+" "+valuesList.get(0));
                timeTable.setEleven(keysList.get(1)+" "+valuesList.get(1));
                timeTable.setTwelve(keysList.get(2)+" "+valuesList.get(2));
                timeTable.setOne("lunch time");
                timeTable.setTwo(keysList.get(3)+" "+valuesList.get(3));
                timeTable.setThree(keysList.get(4)+" "+valuesList.get(4));
                TimeTable timeTable2=timeTableRepository.save(timeTable);
                System.out.println(timeTable2);
                System.out.println("timetable");
                for(int i=0;i<keysList.size();i++)
                {
                    System.out.println("for loop");
                    String fid=facultyRepository.findFidByFacultyName(valuesList.get(i));
                    String sid=subjectRepository.findSidBySubject(keysList.get(i));
                    Allotment allotment=new Allotment();
                    allotment.setSid_fk(sid);
                    allotment.setFid_fk(fid);
                    allotment.setCsid_fk(csid_fk);
                    allotment.setTime(monday1.get(i));
                    Allotment allotment2=allotmentRepository.save(allotment);
                    System.out.println(allotment2);
                }


            }
            else{
                
            }
            return day1;

        }
    //     String day1=day[0];
    //    TimeTable timeTable=new TimeTable();
    //    timeTable.setTableid_fk(tableid);
    //    timeTable.setDay(day1);
    //    timeTable.setTen("DBMS tarjani");
    //    timeTable.setEleven("AUTOMATA chaitali mam");
    //    timeTable.setTwelve("frevv");
    //    timeTable.setOne("lunch time");
    //    timeTable.setTwo("efrfregr");
    //    timeTable.setThree("rgrtbr");
    //    TimeTable timeTable2=timeTableRepository.save(timeTable);
    //    System.out.println(timeTable2);
    return null;
        
    }

}
