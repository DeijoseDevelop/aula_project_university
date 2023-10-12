package src;

import java.util.ArrayList;

public class AcademicProgram {
    private static int countAcademicPrograms;
    private int id;
    private String name;
    private ArrayList<Subject> subjects;
    private ArrayList<Student> students;

    public AcademicProgram(String name) {
        this.id = ++AcademicProgram.countAcademicPrograms;
        this.name = name;
        this.subjects = new ArrayList<Subject>();
        this.students = new ArrayList<Student>();
    }

    public void addSubject(Subject subject) {
        this.subjects.add(subject);
    }

    public void addAllSubjects(Subject... subjects) {
        for (Subject subject : subjects) {
            this.subjects.add(subject);
        }
    }

    public void addStudent(Student student) {
        this.students.add(student);
    }

    public void addAllStudents(Student... students) {
        for (Student student : students) {
            this.students.add(student);
        }
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public ArrayList<Subject> getSubjects() {
        return subjects;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    @Override
    public String toString() {
        return String.format("AcademicProgram(id=%d)", this.id);
    }
}
