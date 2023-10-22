package src.models;

import java.util.Map;

import src.constants.Constants;
import src.interfaces.DataModel;

public class AcademicProgram implements DataModel{
    private static int countAcademicPrograms;
    private int id;
    private String name;

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

    public static AcademicProgram fromJson(Map<String, String> json) {
        return new AcademicProgram(
            json.get("name")
        );
    }

    @Override
    public String toString() {
        return String.format("AcademicProgram(name=%s)", this.name);
    }
}
