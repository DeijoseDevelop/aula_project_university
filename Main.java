import java.io.IOException;
import java.util.*;

import src.constants.Constants;
import src.enums.CivilState;
import src.enums.Gender;
import src.enums.InscriptionState;
import src.enums.TypeDocument;
import src.models.*;
import src.utils.DataFilter;
import src.utils.ExcelReader;
import src.utils.ExcelWriter;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        final short ICFES_MIN_SCORE = 300;

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

            Main.clearScreen();

            System.out.println(String.format("you have chosen: %s.", selectedAcademicPeriod.getName()));

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

            Main.clearScreen();

            System.out.println();
            System.out.println(String.format("you have chosen period: %s.", selectedProgram.getName()));
            System.out.println();

            System.out.println("Enter your first name: ");
            String firstName = scanner.next();

            System.out.println("Enter your last name: ");
            String lastName = scanner.next();

            System.out.println("Enter your email: ");
            String email = scanner.next();

            System.out.println("Enter your phone number: ");
            long phoneNumber = scanner.nextLong();

            System.out.println("Enter your gender (M - F): ");
            String optionGender = scanner.next();
            Gender gender = Constants.genders.get(optionGender.toLowerCase());

            scanner.nextLine();

            System.out.println("Enter your address: ");
            String address = scanner.nextLine();

            System.out.println("Enter your civil state: ");
            System.out.println("1.SINGLE");
            System.out.println("2.MARRIED");
            System.out.println("3.DIVORCED");
            System.out.println("4.WIDOWER");
            byte optionCivilState = scanner.nextByte();
            CivilState civilState = Constants.civilStatesByIndex.get(optionCivilState);

            System.out.println("Enter your type document: ");
            System.out.println("1.CC");
            System.out.println("2.CE");
            System.out.println("3.PASSPORT");
            System.out.println("4.PPT");
            byte optionTypeDocument = scanner.nextByte();
            TypeDocument typeDocument = Constants.typeDocumentsByIndex.get(optionTypeDocument);

            System.out.println("Enter your document number: ");
            Long documentNumber = scanner.nextLong();

            System.out.println("Are you a high school graduate? ");
            System.out.println("1.YES");
            System.out.println("2.NO");
            byte optionIsBachiller = scanner.nextByte();
            boolean isBachiller = Constants.optionToBoolean.get(optionIsBachiller);

            scanner.nextLine();

            System.out.println("Enter your EPS name: ");
            String nameEPS = scanner.nextLine();

            Applicant applicant = new Applicant(
                firstName,
                lastName,
                email,
                phoneNumber,
                gender,
                address,
                civilState,
                typeDocument,
                documentNumber,
                isBachiller,
                nameEPS
            );

            Map<String, String> applicantJson = applicant.toJson();

            Main.clearScreen();
            System.out.println("Please, wait a moment.");
            excelWriterApplicants.writeData(applicantJson);

            System.out.println("Did you take the icfes? ");
            System.out.println("1.YES");
            System.out.println("2.NO");
            byte optionIcfes = scanner.nextByte();

            System.out.println("Do you have a certificate from your eps? ");
            System.out.println("1.YES");
            System.out.println("2.NO");
            byte optionHaveEps = scanner.nextByte();
            boolean haveEps = Constants.optionToBoolean.get(optionHaveEps);

            if (optionIcfes == 2) {
                System.out.println("You can't register, you need to take the icfes.");
                break;
            }

            System.out.println("What was your score in icfes? ");
            short icfesScore = scanner.nextShort();

            System.out.println("Please wait a moment while we validate your information.");
            Thread.sleep(4000);

            System.out.println(icfesScore);
            System.out.println(applicant.isBachiller());
            System.out.println(applicant.getNameEPS());
            System.out.println(haveEps);

            if (
                icfesScore < ICFES_MIN_SCORE
                || !applicant.isBachiller()
                || applicant.getNameEPS().isEmpty()
                || !haveEps
            ) {
                Main.clearScreen();
                System.out.println();
                System.out.println("Your application has been denied due to insufficient requirements.");
                System.out.println();
                break;
            }

            Main.clearScreen();

            Student student = Student.fromJson(applicantJson);
            System.out.println(String.format(
                "Welcome %s, you have been admitted and are enrolled in the %s program.",
                student.getFullName(),
                academicPrograms.get(option - 1).getName()
            ));

            excelWriterStudents.writeData(student.toJson());
            student.setInscriptionState(InscriptionState.ENROLLED);

            break;
        } while (true);

        scanner.close();
    }

    public static void clearScreen() {
        try {
        if (System.getProperty("os.name").contains("Windows"))
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        else
            Runtime.getRuntime().exec("clear");
    } catch (IOException | InterruptedException ex) {}
    }
}
