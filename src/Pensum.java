package src;

import java.util.*;

public class Pensum {
    private static int countPensum;
    private int id;
    private short year;
    private AcademicProgram program;
    private List<Subject> subjects;

    public Pensum() {
        this.id = ++Pensum.countPensum;
        this.subjects = new ArrayList<Subject>();
    }

    public Pensum(short year, AcademicProgram program) {
        this.id = ++Pensum.countPensum;
        this.year = year;
        this.program = program;
        this.subjects = new ArrayList<Subject>();
    }

    public void addSubject(Subject subject) {
        this.subjects.add(subject);
    }

    public void addAllSubjects(Subject... subjects) {
        for (Subject subject : subjects) {
            this.subjects.add(subject);
        }
    }

    public int getId() {
        return id;
    }

    public short getYear() {
        return year;
    }

    public void setYear(short year) {
        this.year = year;
    }

    public AcademicProgram getProgram() {
        return program;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }
}
