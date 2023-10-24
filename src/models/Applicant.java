package src.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import src.constants.Constants;
import src.enums.CivilState;
import src.enums.InscriptionState;
import src.interfaces.DataModel;
import src.interfaces.Person;

public class Applicant extends Person implements DataModel {
    private static int countApplicant;

    public Applicant() {
        this.id = ++Applicant.countApplicant;
    }

    public Applicant(
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
        this.id = ++Applicant.countApplicant;
        this.inscriptionState = InscriptionState.APPLICANT;
    }

    public static List<Applicant> fromJsonList(List<Map<String, String>> jsonList) {
        List<Applicant> applicants = new ArrayList<Applicant>();
        for (Map<String, String> json : jsonList) {
            applicants.add(Applicant.fromJson(json));
        }
        return applicants;
    }

    public static Applicant fromJson(Map<String, String> json) {
        return new Applicant(
            json.get("first_name"),
            json.get("last_name"),
            json.get("email"),
            Long.parseLong(json.get("phone")),
            json.get("gender"),
            json.get("address"),
            Constants.civilStates.get(json.get("civil_state")),
            json.get("type_document"),
            Long.parseLong(json.get("document_number")),
            json.get("eps")
        );
    }

    @Override
    public String toString() {
        return String.format("Applicant(name=%s)", this.getFullName());
    }
}
