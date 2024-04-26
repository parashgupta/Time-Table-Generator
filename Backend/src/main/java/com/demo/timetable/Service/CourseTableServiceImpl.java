package com.demo.timetable.Service;


import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.aspectj.internal.lang.annotation.ajcDeclareAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.timetable.Entity.CourseSemester;
import com.demo.timetable.Entity.CourseTable;
import com.demo.timetable.Entity.TimeTable;
import com.demo.timetable.Repository.CourseSemesterRepository;
import com.demo.timetable.Repository.CourseTableRespository;
import com.demo.timetable.Repository.SectionRepository;
import com.demo.timetable.Repository.TimeTableRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;


@Service
public class CourseTableServiceImpl implements CourseTableService{


@Autowired
private CourseTableRespository courseTableRespository;
@Autowired
private CourseSemesterRepository courseSemesterRepository;
@Autowired
private SectionRepository sectionRepository;
@Autowired
private TimeTableRepository timeTableRepository;
@Autowired
private TimeTableServiceImpl timeTableServiceImpl;


    public Boolean downloadExcel(String courseName, String semester, String secName){
        String jdbcUrl = "jdbc:mysql://localhost:3306/Timetable";
        String username = "root";
        String password = "boot@123";
        Integer csid_fk=courseSemesterRepository.findCourseSemesterId(courseName, semester);
        System.out.println("csid------------>"+csid_fk);
        Boolean secCheck=courseSemesterRepository.checkSection(csid_fk);
        Integer secid_fk=null;
        if(secCheck)
        {
            secid_fk=sectionRepository.findSectionId(secName,csid_fk);
        }
        System.out.println("secid----------->"+secid_fk);
        String userDownloadsDir = System.getProperty("user.home") + "/Downloads/";
        Integer tableid_pk=courseTableRespository.findCourseTableId(csid_fk,secid_fk);
        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT day as DAY,ten as '10:00 to 11:00',eleven as '11:00 to 12:00',twelve as '12:00 to 1:00',one as '1:00 to 2:00',two as '2:00 to 3:00',three as '3:00 to 4:00' FROM TimeTable WHERE tableid_fk ='"+tableid_pk+"'");
             FileOutputStream fileOut = new FileOutputStream(""+userDownloadsDir+""+courseName+"_"+semester+"_"+secName+".xlsx")) {
                
            XSSFWorkbook workbook = new XSSFWorkbook();
            org.apache.poi.ss.usermodel.Sheet sheet = workbook.createSheet("Sheet1");

            // Create header row
            Row headerRow = sheet.createRow(0);
            int columnCount = resultSet.getMetaData().getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                Cell cell = headerRow.createCell(i - 1);
                cell.setCellValue(resultSet.getMetaData().getColumnName(i));
            }

            // Create data rows
            int rowNumber = 1;
            while (resultSet.next()) {
                Row dataRow = sheet.createRow(rowNumber++);
                for (int i = 1; i <= columnCount; i++) {
                    Cell cell = dataRow.createCell(i - 1);
                    cell.setCellValue(resultSet.getString(i));
                }
            }

            workbook.write(fileOut);
            System.out.println("Data exported to Excel successfully.");
            

        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public Iterable<TimeTable> finalTimeTable(String courseName, String semester, String secName) {
        
        Integer csid_fk=courseSemesterRepository.findCourseSemesterId(courseName, semester);
        System.out.println("csid------------>"+csid_fk);
        Boolean secCheck=courseSemesterRepository.checkSection(csid_fk);
        Integer secid_fk=null;
        if(secCheck)
        {
            secid_fk=sectionRepository.findSectionId(secName,csid_fk);
        }
        System.out.println("secid----------->"+secid_fk);
        Integer tableid_pk=courseTableRespository.findCourseTableId(csid_fk,secid_fk);
        System.out.println("==============================================>"+tableid_pk);
        return timeTableRepository.findAllByTableId(tableid_pk);
        // return courseSemesterRepository.findAll();
        
    }
    @Override
    public void setCourseTable(String courseName, String semester, String secName,Map<String,String> subjectWithFaculty)
    {   
        System.out.println("=====================>"+courseName);
        System.out.println("=====================>"+semester);
        System.out.println("=====================>"+secName);
        Integer csid_fk=courseSemesterRepository.findCourseSemesterId(courseName, semester);
        System.out.println("csid=====================>"+csid_fk);

        Integer secid_fk=sectionRepository.findSectionId(secName,csid_fk);
        System.out.println("secid_fk=====================>"+secid_fk);

        CourseTable courseTable=new CourseTable();
        courseTable.setCsid_fk(csid_fk);
        courseTable.setSecid_fk(secid_fk);
        CourseTable ct=courseTableRespository.save(courseTable);
        Integer tableid=ct.getTableid_pk();
      
        timeTableServiceImpl.generateTimeTables(tableid,subjectWithFaculty,csid_fk);
    }   
    

   
    
    
}
