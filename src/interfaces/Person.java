package src.interfaces;

import src.enums.*;

public abstract class Person {
    protected int id;
    protected String firstName;
    protected String lastName;
    protected InscriptionState inscriptionState;
    protected String email;
    protected Long phoneNumber;
    protected Gender gender;
    protected String address;
    protected CivilState civilState;
    protected TypeDocument typeDocument;
    protected Long documentNumber;
    protected boolean isBachiller;
    protected String nameEPS;

    public Person() {}

    public Person(
        String firstName,
        String lastName,
        String email,
        Long phoneNumber,
        Gender gender,
        String address,
        CivilState civilState,
        TypeDocument typeDocument,
        Long documentNumber,
        boolean isBachiller,
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
        this.isBachiller = isBachiller;
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

    public InscriptionState gInscriptionState() {
        return this.inscriptionState;
    }

    public String getEmail() {
        return this.email;
    }

    public Long getPhoneNumber() {
        return this.phoneNumber;
    }

    public Gender getGender() {
        return this.gender;
    }

    public String getAddress() {
        return this.address;
    }

    public CivilState getCivilState() {
        return this.civilState;
    }

    public TypeDocument getTypeDocument() {
        return this.typeDocument;
    }

    public Long getDocumentNumber() {
        return this.documentNumber;
    }

    public boolean isBachiller() {
        return isBachiller;
    }

    public String getNameEPS() {
        return this.nameEPS;
    }

    public void setInscriptionState(InscriptionState inscriptionState) {
        this.inscriptionState = inscriptionState;
    }
}
