package src;

import java.util.ArrayList;

public class University {
    private static int countUniversities;
    private int id;
    // private ArrayList<Subject> subjects;
    private ArrayList<Classroom> classrooms;
    private ArrayList<Teacher> teachers;
    private ArrayList<AcademicProgram> academicPrograms;

    public University() {
        this.id = ++University.countUniversities;
        // this.subjects = new ArrayList<Subject>();
        this.classrooms = new ArrayList<Classroom>();
        this.teachers = new ArrayList<Teacher>();
        this.academicPrograms = new ArrayList<AcademicProgram>();
    };

    public void manageRegistrations() {}

    public void manageAssistance() {}

    // public void addSubject(Subject subject) {
    //     this.subjects.add(subject);
    // }

    // public void addAllSubjects(Subject... subjects) {
    //     for (Subject subject : subjects) {
    //         this.subjects.add(subject);
    //     }
    // }

    public void addClassroom(Classroom classroom) {
        this.classrooms.add(classroom);
    }

    public void addAllClassrooms(Classroom... Classrooms) {
        for (Classroom Classroom : Classrooms) {
            this.classrooms.add(Classroom);
        }
    }

    public void addTeacher(Teacher teacher) {
        this.teachers.add(teacher);
    }

    public void addAllTeachers(Teacher... teachers) {
        for (Teacher teacher : teachers) {
            this.teachers.add(teacher);
        }
    }

    public void addAcademicProgram(AcademicProgram academicProgram) {
        this.academicPrograms.add(academicProgram);
    }

    public void addAllAcademicPrograms(AcademicProgram... academicPrograms) {
        for (AcademicProgram academicProgram : academicPrograms) {
            this.academicPrograms.add(academicProgram);
        }
    }

    public int getId() {
        return this.id;
    }

    // public ArrayList<Subject> getSubjects() {
    //     return this.subjects;
    // }

    public ArrayList<Classroom> getClassrooms() {
        return this.classrooms;
    }

    public ArrayList<Teacher> getTeachers() {
        return this.teachers;
    }

    public ArrayList<AcademicProgram> getAcademicPrograms() {
        return this.academicPrograms;
    }

    @Override
    public String toString() {
        return String.format("University(id=%d)", this.id);
    }
}
