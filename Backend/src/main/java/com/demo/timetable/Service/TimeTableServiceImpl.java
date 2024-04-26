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
        List<String> wednesday1=new ArrayList<>();
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

        wednesday1.add("W10");
        wednesday1.add("W11");
        wednesday1.add("W12");
        wednesday1.add("W2");
        wednesday1.add("W3");
        wednesday.put("wednesday", wednesday1);

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
   
    // public String generateTimeTables(Integer tableid,Map<String,String> subjectWithFaculty,Integer csid_fk) {
       
    //     List<String> keysList = new ArrayList<>(subjectWithFaculty.keySet());
    //     List<String> valuesList = new ArrayList<>(subjectWithFaculty.values());
    //     // for(String day1:day)
    //     // {
            
    //     //     TimeTable timeTable=new TimeTable();
    //     //     timeTable.setTableid_fk(tableid);
    //     //     timeTable.setDay(day1);
    //     //     System.out.println("before if");

    //     //     if(isAllotmentTableEmpty())
    //     //     {
    //     //         System.out.println("after if");
    //     //         timeTable.setTen(keysList.get(0)+" "+valuesList.get(0));
    //     //         timeTable.setEleven(keysList.get(1)+" "+valuesList.get(1));
    //     //         timeTable.setTwelve(keysList.get(2)+" "+valuesList.get(2));
    //     //         timeTable.setOne("lunch time");
    //     //         timeTable.setTwo(keysList.get(3)+" "+valuesList.get(3));
    //     //         timeTable.setThree(keysList.get(4)+" "+valuesList.get(4));
    //     //         TimeTable timeTable2=timeTableRepository.save(timeTable);
    //     //         System.out.println(timeTable2);
    //     //         System.out.println("timetable");
    //     //         for(int i=0;i<keysList.size();i++)
    //     //         {
    //     //             System.out.println("for loop");
    //     //             String fid=facultyRepository.findFidByFacultyName(valuesList.get(i));
    //     //             String sid=subjectRepository.findSidBySubject(keysList.get(i));
    //     //             Allotment allotment=new Allotment();
    //     //             allotment.setSid_fk(sid);
    //     //             allotment.setFid_fk(fid);
    //     //             allotment.setCsid_fk(csid_fk);
    //     //             allotment.setTime(monday1.get(i));
    //     //             Allotment allotment2=allotmentRepository.save(allotment);
    //     //             System.out.println(allotment2);
    //     //         }


    //     //     }
    //     //     else{



    //     //     }
    //     //     return day1;
    //     for (String day1 : day) {
    //         TimeTable timeTable = new TimeTable();
    //         timeTable.setTableid_fk(tableid);
    //         timeTable.setDay(day1);
    
    //         Map<String, List<String>> dayMap = getDayMap(day1);
    //         if (dayMap != null) {
    //             List<String> timeSlots = dayMap.get(day1.toLowerCase());
    //             if (timeSlots != null && !timeSlots.isEmpty()) {

    //                 for (int i = 0; i < keysList.size(); i++) {
    //                     String subject = keysList.get(i);
    //                     String faculty = valuesList.get(i);
    
    //                     String timeSlot = findNextAvailableSlot(timeSlots, faculty);
    //                     System.out.println(timeSlot);
    //                     if (timeSlot != null) {
    //                         String fid = facultyRepository.findFidByFacultyName(faculty);
    //                         String sid = subjectRepository.findSidBySubject(subject);
    
    //                         Allotment allotment = new Allotment();
    //                         allotment.setSid_fk(sid);
    //                         allotment.setFid_fk(fid);
    //                         allotment.setCsid_fk(csid_fk);
    //                         allotment.setTime(timeSlot);
    //                         allotmentRepository.save(allotment);
    
    //                         // Update timetable with subject and faculty for the time slot
    //                         switch (timeSlot) {
                                // case "M10":
                                //     timeTable.setTen(subject + " " + faculty);
                                //     break;
                                // case "M11":
                                //     timeTable.setEleven(subject + " " + faculty);
                                //     break;
                                // case "M12":
                                //     timeTable.setTwelve(subject + " " + faculty);
                                //     break;
                                // case "M2":
                                //     timeTable.setTwo(subject + " " + faculty);
                                //     break;
                                // case "M3":
                                //     timeTable.setThree(subject + " " + faculty);
                                //     break;
                                // case "T10":
                                //     timeTable.setTen(subject + " " + faculty);
                                //     break;
                                // case "T11":
                                //     timeTable.setEleven(subject + " " + faculty);
                                //     break;
                                // case "T12":
                                //     timeTable.setTwelve(subject + " " + faculty);
                                //     break;
                                // case "T2":
                                //     timeTable.setTwo(subject + " " + faculty);
                                //     break;
                                // case "T3":
                                //     timeTable.setThree(subject + " " + faculty);
                                //     break;
                                // case "W10":
                                //     timeTable.setTen(subject + " " + faculty);
                                //     break;
                                // case "W11":
                                //     timeTable.setEleven(subject + " " + faculty);
                                //     break;
                                // case "W12":
                                //     timeTable.setTwelve(subject + " " + faculty);
                                //     break;
                                // case "W2":
                                //     timeTable.setTwo(subject + " " + faculty);
                                //     break;
                                // case "W3":
                                //     timeTable.setThree(subject + " " + faculty);
                                //     break;
                                // case "TH10":
                                //     timeTable.setTen(subject + " " + faculty);
                                //     break;
                                // case "TH11":
                                //     timeTable.setEleven(subject + " " + faculty);
                                //     break;
                                // case "TH12":
                                //     timeTable.setTwelve(subject + " " + faculty);
                                //     break;
                                // case "TH2":
                                //     timeTable.setTwo(subject + " " + faculty);
                                //     break;
                                // case "TH3":
                                //     timeTable.setThree(subject + " " + faculty);
                                //     break;
                                // case "F10":
                                //     timeTable.setTen(subject + " " + faculty);
                                //     break;
                                // case "F11":
                                //     timeTable.setEleven(subject + " " + faculty);
                                //     break;
                                // case "F12":
                                //     timeTable.setTwelve(subject + " " + faculty);
                                //     break;
                                // case "F2":
                                //     timeTable.setTwo(subject + " " + faculty);
                                //     break;
                                // case "F3":
                                //     timeTable.setThree(subject + " " + faculty);
                                //     break;
                                // case "S10":
                                //     timeTable.setTen(subject + " " + faculty);
                                //     break;
                                // case "S11":
                                //     timeTable.setEleven(subject + " " + faculty);
                                //     break;
                                // case "S12":
                                //     timeTable.setTwelve(subject + " " + faculty);
                                //     break;
                                // case "S2":
                                //     timeTable.setTwo(subject + " " + faculty);
                                //     break;
                                // case "S3":
                                //     timeTable.setThree(subject + " " + faculty);
                                //     break;
                                
                                
    //                         }
    //                     }
    //                 }
    //             }
    //         }
    //         timeTable.setOne("Lunch Time");
    //         // Save timetable entry for the day
    //         timeTableRepository.save(timeTable);
    //     }
    
    //     return "Time tables generated successfully!";

    // }
   

    private Map<String, List<String>> getDayMap(String day) {
        switch (day.toLowerCase()) {
            case "monday":
                return monday;
            case "tuesday":
                return tuesday;
            case "wednesday":
                return wednesday;
            case "thursday":
                return thursday;
            case "friday":
                return friday;
            case "saturday":
                return saturday;
            default:
                return null;
        }
    }


    // private String findNextAvailableSlot(List<String> timeSlots, String faculty) {

    //     String fid_fk = facultyRepository.findFidByFacultyName(faculty);
    //     List<String> occupiedSlots = allotmentRepository.findOccupiedSlotsByFaculty(fid_fk);
    
    //     // Find the first available slot by checking if it exists in the timeSlots list but not in the occupiedSlots list
    //     for (String slot : timeSlots) {
    //         if (!occupiedSlots.contains(slot)) {
    //             return slot;
    //         }
    //     }
    
    //     // Return null if all slots are occupied
    //     return null;
    // }

    // public String generateTimeTables(Integer tableid, Map<String, String> subjectWithFaculty, Integer csid_fk) {
    //     List<String> keysList = new ArrayList<>(subjectWithFaculty.keySet());
    //     List<String> valuesList = new ArrayList<>(subjectWithFaculty.values());
    
    //     for (String day1 : day) {
    //         TimeTable timeTable = new TimeTable();
    //         timeTable.setTableid_fk(tableid);
    //         timeTable.setDay(day1);
    
    //         Map<String, List<String>> dayMap = getDayMap(day1);
    //         if (dayMap != null) {
    //             List<String> timeSlots = dayMap.get(day1.toLowerCase());
    //             if (timeSlots != null && !timeSlots.isEmpty()) {
    //                 for (String timeSlot : timeSlots) {
    //                     String subject = null;
    //                     String faculty = null;
    //                     // Find a subject and faculty pair that is not already assigned
    //                     do {
    //                         int index = (int) (Math.random() * keysList.size());
    //                         subject = keysList.get(index);
    //                         faculty = valuesList.get(index);
    //                     } while (!isSubjectFacultyPairAvailable(subject, faculty, timeSlot));
    
    //                     if (subject != null && faculty != null) {
    //                         // Faculty is available for this time slot, assign subject and faculty
    //                         setTimeSlot(timeTable, timeSlot, subject, faculty);
    //                         // Update allotment
    //                         updateAllotment(subject, faculty, csid_fk, timeSlot);
    //                     } else {
    //                         // No faculty available for this time slot
    //                         // Handle this case as needed, e.g., log a warning or throw an exception
    //                     }
    //                 }
    //             }
    //         }
    //         // Save timetable entry for the day
    //         timeTableRepository.save(timeTable);
    //     }
    
    //     return "Time tables generated successfully!";
    // }

    public String generateTimeTables(Integer tableid, Map<String, String> subjectWithFaculty, Integer csid_fk) {
        List<String> keysList = new ArrayList<>(subjectWithFaculty.keySet());
        List<String> valuesList = new ArrayList<>(subjectWithFaculty.values());
    
        for (String day1 : day) {
            TimeTable timeTable = new TimeTable();
            timeTable.setTableid_fk(tableid);
            timeTable.setDay(day1);
    
            Map<String, List<String>> dayMap = getDayMap(day1);
            if (dayMap != null) {
                List<String> timeSlots = dayMap.get(day1.toLowerCase());
                if (timeSlots != null && !timeSlots.isEmpty()) {
                    List<String> usedSubjects = new ArrayList<>();
                    List<String> usedFaculties = new ArrayList<>();
                    for (String timeSlot : timeSlots) {
                        String subject = null;
                        String faculty = null;
                        // Find a subject and faculty pair that is not already assigned
                        do {
                            int index = (int) (Math.random() * keysList.size());
                            subject = keysList.get(index);
                            faculty = valuesList.get(index);
                        } while (!isSubjectFacultyPairAvailable(subject, faculty, timeSlot)
                                || usedSubjects.contains(subject)
                                || usedFaculties.contains(faculty));
    
                        if (subject != null && faculty != null) {
                            // Faculty is available for this time slot, assign subject and faculty
                            setTimeSlot(timeTable, timeSlot, subject, faculty);
                            timeTable.setOne("Lunch Time");
                            // Update allotment
                            updateAllotment(subject, faculty, csid_fk, timeSlot);
                            usedSubjects.add(subject);
                            usedFaculties.add(faculty);
                        } else {
                            // No faculty available for this time slot
                            // Handle this case as needed, e.g., log a warning or throw an exception
                        }
                    }
                }
            }
            // Save timetable entry for the day
            timeTableRepository.save(timeTable);
        }
    
        return "Time tables generated successfully!";
    }

    private boolean isSubjectFacultyPairAvailable(String subject, String faculty, String timeSlot) {
        String fid = facultyRepository.findFidByFacultyName(faculty);
        String sid = subjectRepository.findSidBySubject(subject);
        // Check if the faculty is already allotted for this subject in this time slot
        return allotmentRepository.findByFidAndTime(fid, sid, timeSlot) == null;
    }
    
    private void setTimeSlot(TimeTable timeTable, String timeSlot, String subject, String faculty) {
        switch (timeSlot) {
        case "M10":
            timeTable.setTen(subject + " " + faculty);
            break;
        case "M11":
            timeTable.setEleven(subject + " " + faculty);
            break;
        case "M12":
            timeTable.setTwelve(subject + " " + faculty);
            break;
        case "M2":
            timeTable.setTwo(subject + " " + faculty);
            break;
        case "M3":
            timeTable.setThree(subject + " " + faculty);
            break;
        case "T10":
            timeTable.setTen(subject + " " + faculty);
            break;
        case "T11":
            timeTable.setEleven(subject + " " + faculty);
            break;
        case "T12":
            timeTable.setTwelve(subject + " " + faculty);
            break;
        case "T2":
            timeTable.setTwo(subject + " " + faculty);
            break;
        case "T3":
            timeTable.setThree(subject + " " + faculty);
            break;
        case "W10":
            timeTable.setTen(subject + " " + faculty);
            break;
        case "W11":
            timeTable.setEleven(subject + " " + faculty);
            break;
        case "W12":
            timeTable.setTwelve(subject + " " + faculty);
            break;
        case "W2":
            timeTable.setTwo(subject + " " + faculty);
            break;
        case "W3":
            timeTable.setThree(subject + " " + faculty);
            break;
        case "TH10":
            timeTable.setTen(subject + " " + faculty);
            break;
        case "TH11":
            timeTable.setEleven(subject + " " + faculty);
            break;
        case "TH12":
            timeTable.setTwelve(subject + " " + faculty);
            break;
        case "TH2":
            timeTable.setTwo(subject + " " + faculty);
            break;
        case "TH3":
            timeTable.setThree(subject + " " + faculty);
            break;
        case "F10":
            timeTable.setTen(subject + " " + faculty);
            break;
        case "F11":
            timeTable.setEleven(subject + " " + faculty);
            break;
        case "F12":
            timeTable.setTwelve(subject + " " + faculty);
            break;
        case "F2":
            timeTable.setTwo(subject + " " + faculty);
            break;
        case "F3":
            timeTable.setThree(subject + " " + faculty);
            break;
        case "S10":
            timeTable.setTen(subject + " " + faculty);
            break;
        case "S11":
            timeTable.setEleven(subject + " " + faculty);
            break;
        case "S12":
            timeTable.setTwelve(subject + " " + faculty);
            break;
        case "S2":
            timeTable.setTwo(subject + " " + faculty);
            break;
        case "S3":
            timeTable.setThree(subject + " " + faculty);
            break;

        }
    }
    
    // private boolean isFacultyAvailable(String fid, String timeSlot) {
    //     // Check if the faculty is already allotted for this time slot
        
    //     return allotmentRepository.findByFidAndTime(fid, timeSlot) == null;
    // }
    
    private void updateAllotment(String subject, String faculty, Integer csid_fk, String timeSlot) {
        String fid = facultyRepository.findFidByFacultyName(faculty);
        String sid = subjectRepository.findSidBySubject(subject);
    
        Allotment allotment = new Allotment();
        allotment.setSid_fk(sid);
        allotment.setFid_fk(fid);
        allotment.setCsid_fk(csid_fk);
        allotment.setTime(timeSlot);
        allotmentRepository.save(allotment);
    }
    
}

