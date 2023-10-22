import java.util.*;

import src.models.*;
import src.utils.ExcelReader;

public class Main {
    public static void main(String[] args) {
        List<AcademicOffert> academicOffert = new ArrayList<AcademicOffert>();
        List<Student> students = new ArrayList<Student>();
        ExcelReader excelReaderStudents = new ExcelReader("src/data/students.xlsx");
        ExcelReader excelReaderOffert = new ExcelReader("src/data/academic_offert.xlsx");

        System.out.println("");

        for (Map<String, String> json : excelReaderStudents.getJsonData()) {
            students.add(Student.fromJson(json));
        }
        System.out.println(students);

        System.out.println("");

        for (Map<String, String> json : excelReaderOffert.getJsonData()) {
            AcademicOffert offert = AcademicOffert.fromJson(json);
            academicOffert.add(offert);
        }
        System.out.println(academicOffert);

        System.out.println("");
    }
}

