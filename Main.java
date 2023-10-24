import java.util.*;

import src.models.*;
import src.utils.ExcelReader;
import src.utils.ExcelWriter;

public class Main {
    public static void main(String[] args) {
        List<AcademicOffert> academicOffert = new ArrayList<AcademicOffert>();
        ExcelReader excelReaderStudents = new ExcelReader("src/data/students.xlsx");
        ExcelReader excelReaderOffert = new ExcelReader("src/data/academic_offert.xlsx");

        List<Student> students = Student.fromJsonList(excelReaderStudents.getJsonData());

        System.out.println("");

        System.out.println(students);

        System.out.println("");

        for (Map<String, String> json : excelReaderOffert.getJsonData()) {
            AcademicOffert offert = AcademicOffert.fromJson(json);
            academicOffert.add(offert);
        }
        System.out.println(academicOffert);

        System.out.println("");

        ExcelWriter excelWriter = new ExcelWriter("src/data/students.xlsx");

        for (Map<String, String> json : excelReaderStudents.getJsonData()) {
            excelWriter.writeData(json);
        }

        System.out.println("");

        for (Map<String, String> json : excelReaderStudents.getJsonData()) {
            students.add(Student.fromJson(json));
        }
        System.out.println(students);

        System.out.println("");
    }
}
