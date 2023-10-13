package src;

public class Subject {
    private static int countSubjects;
    private int id;
    private String name;
    private String code;
    private Pensum pensum;

    public Subject() {
        this.id = ++Subject.countSubjects;
    }

    public Subject(
        String name,
        String code,
        Pensum pensum
    ) {
        this.id = ++Subject.countSubjects;
        this.name = name;
        this.code = code;
        this.pensum = pensum;
    }

    public void checkAvailability() {}

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getCode() {
        return this.code;
    }

    public Pensum getPensum() {
        return pensum;
    }

    @Override
    public String toString() {
        return String.format("Subject(id=%d)", this.id);
    }
}
