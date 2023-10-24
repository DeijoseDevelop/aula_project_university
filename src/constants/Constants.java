package src.constants;

import java.util.*;
import src.enums.*;

public class Constants {

    public static String STUDENTS_FILE_PATH = "src/data/students.xlsx";
    public static String ACADEMIC_OFFERTS_FILE_PATH = "src/data/academic_offert.xlsx";
    public static String ACADEMIC_PROGRAMS_FILE_PATH = "src/data/academic_programs.xlsx";
    public static String APPLICANTS_FILE_PATH = "src/data/applicants.xlsx";

    public static Map<String, CivilState> civilStates = Map.of(
        "single", CivilState.SINGLE,
        "married", CivilState.MARRIED,
        "divorced", CivilState.DIVORCED,
        "widower", CivilState.WIDOWER
    );

    public static Map<String, Shift> chifts = Map.of(
        "morning", Shift.MORNING,
        "afternoon", Shift.AFTERNOON,
        "night", Shift.NIGHT
    );
}
