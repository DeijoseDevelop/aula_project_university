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

    public static Map<CivilState, String> civilStatesInverse = Map.of(
        CivilState.SINGLE, "single",
        CivilState.MARRIED, "married",
        CivilState.DIVORCED, "divorced",
        CivilState.WIDOWER, "widower"
    );

    public static Map<Byte, CivilState> civilStatesByIndex = Map.of(
        (byte) 1, CivilState.SINGLE,
        (byte) 2, CivilState.MARRIED,
        (byte) 3, CivilState.DIVORCED,
        (byte) 4, CivilState.WIDOWER
    );

    public static Map<String, Shift> chifts = Map.of(
        "morning", Shift.MORNING,
        "afternoon", Shift.AFTERNOON,
        "night", Shift.NIGHT
    );

    public static Map<Byte, Shift> chiftsByIndex = Map.of(
        (byte) 1, Shift.MORNING,
        (byte) 2, Shift.AFTERNOON,
        (byte) 3, Shift.NIGHT
    );

    public static Map<String, TypeDocument> typeDocuments = Map.of(
        "cc", TypeDocument.CC,
        "ce", TypeDocument.CE,
        "passport", TypeDocument.PASSPORT,
        "ppt", TypeDocument.PPT
    );

    public static Map<TypeDocument, String> typeDocumentsInverse = Map.of(
        TypeDocument.CC, "cc",
        TypeDocument.CE, "ce",
        TypeDocument.PASSPORT, "passport",
        TypeDocument.PPT, "ppt"
    );

    public static Map<Byte, TypeDocument> typeDocumentsByIndex = Map.of(
        (byte) 1, TypeDocument.CC,
        (byte) 2, TypeDocument.CE,
        (byte) 3, TypeDocument.PASSPORT,
        (byte) 4, TypeDocument.PPT
    );

    public static Map<Byte, Boolean> optionToBoolean = Map.of(
        (byte) 1, true,
        (byte) 2, false
    );

    public static Map<String, Gender> genders = Map.of(
        "m", Gender.MALE,
        "Male", Gender.MALE,
        "f", Gender.FEMALE,
        "Female", Gender.FEMALE
    );

    public static Map<Gender, String> gendersInverse = Map.of(
        Gender.MALE, "Male",
        Gender.FEMALE, "Female"
    );
}
