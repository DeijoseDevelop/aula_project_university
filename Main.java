import java.time.LocalDate;
import java.time.LocalTime;

import src.*;

public class Main {
    public static void main(String[] args) {
        University university = new University();

        Teacher teacher1 = new Teacher(
            "Carlos",
            "Castro",
            1272727
        );
        Teacher teacher2 = new Teacher(
            "Carlos",
            "Castro",
            1272727
        );
        Teacher teacher3 = new Teacher(
            "Carlos",
            "Castro",
            1272727
        );

        Student student1 = new Student(
            "Juan",
            "Caicedo",
            1778611
        );
        Student student2 = new Student(
            "Lewis",
            "Zambrano",
            1778611
        );
        Student student3 = new Student(
            "Lucas",
            "Torres",
            1778611
        );

        AcademicProgram academicProgram = new AcademicProgram("Sistemas");

        Subject subject = new Subject("Algoritmos", "A01");

        ClassSchedule classSchedule = new ClassSchedule(
            LocalDate.of(2023, 9, 10),
            LocalTime.of(15, 0, 0),
            LocalTime.of(15, 0, 0)
        );

        Classroom classroom = new Classroom(
            "A101",
            38,
            teacher2,
            35
        );

        academicProgram.addSubject(subject);
        academicProgram.addAllStudents(student1, student2, student3);

        classroom.addClassSchedule(classSchedule);

        university.addClassroom(classroom);
        university.addAcademicProgram(academicProgram);
        university.addAllTeachers(teacher1, teacher2, teacher3);

        System.out.println(academicProgram.getName());
        for (Student student : academicProgram.getStudents()) {
            System.out.println(student.getFullName());
        }
        // System.out.println(academicProgram.getStudents());
    }
}

