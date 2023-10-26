import java.time.Period;
import java.util.*;

import src.models.*;
import src.utils.DataFilter;
import src.utils.ExcelReader;
import src.utils.ExcelWriter;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        DataFilter dataFilter = new DataFilter();

        //? Applicants
        ExcelReader excelReaderApplicants = new ExcelReader("src/data/applicants.xlsx");
        ExcelWriter excelWriterApplicants = new ExcelWriter("src/data/applicants.xlsx");

        //? Students
        ExcelReader excelReaderStudents = new ExcelReader("src/data/students.xlsx");
        ExcelWriter excelWriterStudents = new ExcelWriter("src/data/students.xlsx");

        //? Periods
        ExcelReader excelReaderPrograms = new ExcelReader("src/data/academic_programs.xlsx");
        ExcelWriter excelWriterPrograms = new ExcelWriter("src/data/academic_programs.xlsx");

        //? Periods
        ExcelReader excelReaderPeriods = new ExcelReader("src/data/academic_period.xlsx");
        ExcelWriter excelWriterPeriods = new ExcelWriter("src/data/academic_period.xlsx");

        //? Offerts
        ExcelReader excelReaderOfferts = new ExcelReader("src/data/academic_offert.xlsx");
        ExcelWriter excelWriterOfferts = new ExcelWriter("src/data/academic_offert.xlsx");

        List<AcademicProgram> academicPrograms = AcademicProgram.fromJsonList(
            excelReaderPrograms.getJsonData()
        );

        dataFilter.setAcademicPrograms(academicPrograms);

        List<AcademicPeriod> academicPeriods = AcademicPeriod.fromJsonList(
            excelReaderPeriods.getJsonData()
        );

        dataFilter.setAcademicPeriods(academicPeriods);

        List<AcademicOffert> academicOfferts = AcademicOffert.fromJsonList(
            excelReaderOfferts.getJsonData(),
            dataFilter
        );

        dataFilter.setAcademicOfferts(academicOfferts);

        for (AcademicOffert academicOffert : academicOfferts) {
            academicOffert.getAcademicPeriod().addAcademicOffert(academicOffert);
            academicOffert.getAcademicProgram().setAcademicOffert(academicOffert);
        }

        do {
            System.out.println("Welcome to the university!!!");
            System.out.println();
            System.out.println("In which shift would you like to study?");
            System.out.println();

            for (int i = 0; i < academicPeriods.size(); i++) {
                AcademicPeriod academicPeriod = academicPeriods.get(i);
                System.out.println(String.format(
                    "%d.%s",
                    i + 1,
                    academicPeriod.getName()
                ));
            }

            System.out.println();
            byte option = scanner.nextByte();

            AcademicPeriod selectedAcademicPeriod = academicPeriods.get(option - 1);

            System.out.println(String.format("you have chosen: %s", selectedAcademicPeriod.getName()));

            System.out.println();
            System.out.println("What program would you like to enroll in?");
            System.out.println();

            for (int i = 0; i < academicPrograms.size(); i++) {
                AcademicProgram academicProgram = academicPrograms.get(i);
                System.out.println(String.format(
                    "%d.%s",
                    i + 1,
                    academicProgram.getName()
                ));
            }

            System.out.println();
            option = scanner.nextByte();

            AcademicProgram selectedProgram = academicPrograms.get(option - 1);

            System.out.println(String.format("you have chosen period: %s", selectedProgram.getName()));
            System.out.println();

            break;
        } while (true);

        scanner.close();
    }
}
