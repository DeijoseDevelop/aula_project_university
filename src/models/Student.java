package src.models;

import java.util.Map;

import src.constants.Constants;
import src.enums.CivilState;
import src.enums.InscriptionState;
import src.interfaces.DataModel;
import src.interfaces.Person;

public class Student extends Person implements DataModel {
    private static int countStudent;

    public Student() {
        this.id = ++Student.countStudent;
    }

    public Student(
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
        super(
            firstName,
            lastName,
            email,
            phoneNumber,
            gender,
            address,
            civilState,
            typeDocument,
            documentNumber,
            nameEPS
        );
        this.id = ++Student.countStudent;
        this.inscriptionState = InscriptionState.ADMITTED;
    }

    @Override
    public String toString() {
        return String.format("Student(name=%s)", this.getFullName());
    }

    public static Student fromJson(Map<String, String> json) {
        Constants constants = new Constants();
        return new Student(
            json.get("first_name"),
            json.get("last_name"),
            json.get("email"),
            Long.parseLong(json.get("phone")),
            json.get("gender"),
            json.get("address"),
            constants.getCivilState(json.get("civil_state")),
            json.get("type_document"),
            Long.parseLong(json.get("document_number")),
            json.get("eps")
        );
    }
}