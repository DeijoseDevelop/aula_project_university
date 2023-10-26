package src.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import src.interfaces.DataModel;

public class AcademicProgram implements DataModel{
    private static int countAcademicPrograms;
    private int id;
    private String name;
    private AcademicOffert academicOffert;

    public AcademicProgram() {
        this.id = ++AcademicProgram.countAcademicPrograms;
    }

    public AcademicProgram(String name) {
        this.id = ++AcademicProgram.countAcademicPrograms;
        this.name = name;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public AcademicOffert getAcademicOffert() {
        return academicOffert;
    }

    public static List<AcademicProgram> fromJsonList(List<Map<String, String>> jsonList) {
        List<AcademicProgram> academicPrograms = new ArrayList<AcademicProgram>();
        for (Map<String, String> json : jsonList) {
            academicPrograms.add(AcademicProgram.fromJson(json));
        }
        return academicPrograms;
    }

    public static AcademicProgram fromJson(Map<String, String> json) {
        return new AcademicProgram(
            json.get("name")
        );
    }

    public static AcademicProgram getObj(List<AcademicProgram> data, int id) throws Exception {
        AcademicProgram selectedAcademicProgram = null;
        for (AcademicProgram academicProgram : data) {
            if (academicProgram.getId() == id) selectedAcademicProgram = academicProgram;
        }

        if (selectedAcademicProgram == null) {
            throw new Exception("There is no such academic program.");
        }

        return selectedAcademicProgram;
    }

    public void setAcademicOffert(AcademicOffert academicOffert) {
        this.academicOffert = academicOffert;
    }

    @Override
    public String toString() {
        return String.format("AcademicProgram(name=%s)", this.name);
    }
}
