package src;

public class Subject {
    private static int countSubjects;
    private int id;
    private String name;
    private String code;
    // private ClassSchedule[] schedules;
    // private int countSchedules;
    // private static int MAX_SCHEDULES = 1000;
    // private AcademicProgram program;

    public Subject() {
        this.id = ++Subject.countSubjects;
    }

    public Subject(
        String name,
        String code
        // AcademicProgram program
    ) {
        this.id = ++Subject.countSubjects;
        this.name = name;
        this.code = code;
        // this.program = program;
        // this.schedules = new ClassSchedule[Subject.MAX_SCHEDULES];
    }

    public void checkAvailability() {}

    // public void addClassSchedule(ClassSchedule schedule) {
    //     this.schedules[this.countSchedules++] = schedule;

    //     if (this.countSchedules < Subject.MAX_SCHEDULES) {
    //         this.schedules[this.countSchedules++] = schedule;

    //         System.out.println("Aggregated schedule");
    //     }
    //     else {
    //         System.out.println(String.format("Full shcedules, limit of %d", Subject.MAX_SCHEDULES));
    //     }
    // }

    // public ClassSchedule getSchedule(int position) {
    //     return this.schedules[position];
    // }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getCode() {
        return this.code;
    }

    // public AcademicProgram getProgram() {
    //     return program;
    // }

    // public ClassSchedule[] getSchedules() {
    //     return schedules;
    // }

    @Override
    public String toString() {
        return String.format("Subject(id=%d)", this.id);
    }
}
