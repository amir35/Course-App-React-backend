package com.amir35.profileImage;

import com.amir35.course.Course;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProfileImageHelper {
    //public static String[] TYPE = { "image/png", "image/jpeg" };

    public static String TYPE = "image/jpeg";

    public static boolean hasImageFormat(MultipartFile file) {

        if(!TYPE.equals(file.getContentType())) {
            return false;
        }

        return true;
    }

    public static List<Course> excelToCourses(InputStream is) {
        try {
            Workbook workbook = new XSSFWorkbook(is);
            System.out.println("Wrokbook" + workbook);

            Sheet sheet = workbook.getSheet("SHEET");
            System.out.println("Sheet" + sheet);
            Iterator<Row> rows = sheet.iterator();

            List<Course> courses = new ArrayList<Course>();

            int rowNumber = 0;
            while (rows.hasNext()) {
                Row currentRow = rows.next();

                // skip header
                if (rowNumber == 0) {
                    rowNumber++;
                    continue;
                }

                Iterator<Cell> cellsInRow = currentRow.iterator();

                Course course = new Course();

                int cellIdx = 0;
                while (cellsInRow.hasNext()) {
                    Cell currentCell = cellsInRow.next();

                    switch (cellIdx) {
                        case 0:
                            course.setCourseId((int) currentCell.getNumericCellValue());
                            break;

                        case 1:
                            course.setCourseName(currentCell.getStringCellValue());
                            break;

                        case 2:
                            course.setCourseDescription(currentCell.getStringCellValue());
                            break;

                        case 3:
                            course.setCourseImage(currentCell.getStringCellValue());
                            break;

                        default:
                            break;
                    }

                    cellIdx++;
                }

                courses.add(course);
            }

            workbook.close();
            System.out.println("Courses" + courses);

            return courses;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
        }
    }
}
