package src;

public class Applicant {
    private static int countApplicant;
    private int id;
    private String firstName;
    private String lastName;
    private boolean isAdmitted;
    private String email;
    private int phoneNumber;
    private String gender;
    private String address;
    private String civilState;
    private String typeDocument;
    private int documentNumber;
    private String nameEPS;
    private AcademicProgram program;

    public Applicant() {
        this.id = ++Applicant.countApplicant;
    }


    public Applicant(
        String firstName,
        String lastName,
        String email,
        int phoneNumber,
        String gender,
        String address,
        String civilState,
        String typeDocument,
        int documentNumber,
        String nameEPS
    ) {
        this.id = ++Applicant.countApplicant;
        this.firstName = firstName;
        this.lastName = lastName;
        this.isAdmitted = false;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.address = address;
        this.civilState = civilState;
        this.typeDocument = typeDocument;
        this.documentNumber = documentNumber;
        this.nameEPS = nameEPS;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public boolean isAdmitted() {
        return isAdmitted;
    }

    public String getEmail() {
        return email;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public String getGender() {
        return gender;
    }

    public String getAddress() {
        return address;
    }

    public String getCivilState() {
        return civilState;
    }

    public String getTypeDocument() {
        return typeDocument;
    }

    public int getDocumentNumber() {
        return documentNumber;
    }

    public String getNameEPS() {
        return nameEPS;
    }

    public AcademicProgram getProgram() {
        return program;
    }

    public void setProgram(AcademicProgram program) {
        this.program = program;
    }

    @Override
    public String toString() {
        return String.format("Applicant(id=%d)", this.id);
    }
}
