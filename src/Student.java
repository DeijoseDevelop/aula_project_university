package src;

public class Student {
    private static int countStudents;
    private int id;
    private String firstName;
    private String lastName;
    private int documentNumber;

    public Student() {
        this.id = ++Student.countStudents;
    }

    public Student(
        String firstName,
        String lastName,
        int documentNumber
    ) {
        this.id = ++Student.countStudents;
        this.firstName = firstName;
        this.lastName = lastName;
        this.documentNumber = documentNumber;
    }

    public void registerAssistance() {}

    public void registerSubject(Subject subject) {}

    public int getId() {
        return id;
    }

    public String getFullName() {
        return String.format("%s %s", this.firstName, this.lastName);
    }

    public int getDocumentNumber() {
        return documentNumber;
    }

    @Override
    public String toString() {
        return String.format("Student(id=%d)", this.id);
    }
}


