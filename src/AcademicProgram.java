package src;

public class AcademicProgram {
    private static int countAcademicPrograms;
    private int id;
    private String name;

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

    @Override
    public String toString() {
        return String.format("AcademicProgram(id=%d)", this.id);
    }
}
