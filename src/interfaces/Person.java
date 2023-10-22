package src.interfaces;

import src.enums.*;
import src.models.AcademicProgram;

public abstract class Person {
    protected int id;
    protected String firstName;
    protected String lastName;
    protected InscriptionState inscriptionState;
    protected String email;
    protected Long phoneNumber;
    protected String gender;
    protected String address;
    protected CivilState civilState;
    protected String typeDocument;
    protected Long documentNumber;
    protected String nameEPS;
    protected AcademicProgram program;

    public Person() {}

    public Person(
        String firstName,
        String lastName,
        String email,
        Long phoneNumber,
        String gender,
        String address,
        CivilState civilState,
        String typeDocument,
        Long documentNumber,
        String nameEPS
    ) {
        this.firstName = firstName;
        this.lastName = lastName;
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
        return this.id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getFullName() {
        return String.format("%s %s", this.firstName, this.lastName);
    }

    public InscriptionState getStudentState() {
        return this.inscriptionState;
    }

    public String getEmail() {
        return this.email;
    }

    public Long getPhoneNumber() {
        return this.phoneNumber;
    }

    public String getGender() {
        return this.gender;
    }

    public String getAddress() {
        return this.address;
    }

    public CivilState getCivilState() {
        return this.civilState;
    }

    public String getTypeDocument() {
        return this.typeDocument;
    }

    public Long getDocumentNumber() {
        return this.documentNumber;
    }

    public String getNameEPS() {
        return this.nameEPS;
    }

    public AcademicProgram getProgram() {
        return this.program;
    }

    public void setProgram(AcademicProgram program) {
        this.program = program;
    }

    public void setInscriptionState(InscriptionState inscriptionState) {
        this.inscriptionState = inscriptionState;
    }
}
