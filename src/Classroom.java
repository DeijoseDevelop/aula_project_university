package src;

import java.util.ArrayList;

public class Classroom {
    private static int countClassrooms;
    private int id;
    private String numberClassroom;
    private int capacity;
    private Teacher teacher;
    private ArrayList<ClassSchedule> schedules;
    private Student[] students;
    private int countStudents;
    private int maxStudents;

    public Classroom(int maxStudents) {
        this.id = ++Classroom.countClassrooms;
        this.schedules = new ArrayList<ClassSchedule>();
        this.maxStudents = maxStudents;
    }

    public Classroom(
        String numberClassroom,
        int capacity,
        Teacher teacher,
        int maxStudents
    ) {
        this.id = ++Classroom.countClassrooms;
        this.schedules = new ArrayList<ClassSchedule>();
        this.numberClassroom = numberClassroom;
        this.capacity = capacity;
        this.teacher = teacher;
        this.maxStudents = maxStudents;
        this.students = new Student[maxStudents];
    }

    public void assignClassroom(Teacher teacher, Student[] students) {
        this.setTeacher(teacher);
        for (Student student : students) {
            this.addStudent(student);
        }
    }

    public void releaseClassroom() {
        this.students = new Student[this.maxStudents];
        this.countStudents = 0;
        this.schedules.clear();
        this.teacher = null;
    }

    public void addClassSchedule(ClassSchedule schedule) {
        this.schedules.add(schedule);
    }

    public void addStudent(Student student) {
        this.students[this.countStudents++] = student;

        if (this.countStudents < this.capacity) {
            this.students[this.countStudents++] = student;

            System.out.println(String.format("Aggregated student: %s", student.getFullName()));
        }
        else {
            System.out.println(String.format("Full classroom, limit of %d", this.maxStudents));
        }
    }

    public void setNumberClassroom(String numberClassroom) {
        this.numberClassroom = numberClassroom;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setTeacher(Teacher teacher) {
        // TODO: FINISH THIS
        if (this.countStudents < this.capacity) {
            this.teacher = teacher;
        }
        else {
            System.out.println(String.format("Full classroom, limit of %d", this.maxStudents));
        }
    }

    public ClassSchedule getSchedule(int position) {
        return this.schedules.get(position);
    }

    public int getId() {
        return this.id;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public String getNumberClassroom() {
        return this.numberClassroom;
    }

    public ArrayList<ClassSchedule> getSchedules() {
        return this.schedules;
    }

    public Teacher getTeacher() {
        return this.teacher;
    }

    @Override
    public String toString() {
        return String.format("Classroom(id=%d)", this.id);
    }
}
