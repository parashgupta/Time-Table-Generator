package com.demo.timetable.Service;


import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class CourseTableServiceImpl implements CourseTableService{



    public void downloadExcel(String courseName,String semester){
        String jdbcUrl = "jdbc:mysql://localhost:3306/Timetable";
        String username = "root";
        String password = "boot@123";

        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("select c.cname,s.sname,cs.semester from course c inner join course_semester cs on c.cid=cs.cid_f inner join sub_mapping sm on sm.csid_f=cs.csid inner join subject s on s.sid=sm.sid_f ");
             FileOutputStream fileOut = new FileOutputStream("output.xlsx")) {

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
    }
    
}
