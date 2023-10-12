package src;

public class Teacher {
    private static int countTeachers;
    private int id;
    private String firstName;
    private String lastName;
    private int documentNumber;

    public Teacher() {
        this.id = ++Teacher.countTeachers;
    }

    public Teacher(
        String firstName,
        String lastName,
        int documentNumber
    ) {
        this.id = ++Teacher.countTeachers;
        this.firstName = firstName;
        this.lastName = lastName;
        this.documentNumber = documentNumber;
    }

    public void takeAssistance() {}

    public int getId() {
        return this.id;
    }

    public String getFullName() {
        return String.format("%s %s", this.firstName, this.lastName);
    }

    public int getDocumentNumber() {
        return this.documentNumber;
    }

    @Override
    public String toString() {
        return String.format("Teacher(id=%d)", this.id);
    }
}


