package src.models;

import java.util.*;

import src.constants.Constants;
import src.enums.CivilState;
import src.enums.Gender;
import src.enums.InscriptionState;
import src.enums.TypeDocument;
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
        Gender gender,
        String address,
        CivilState civilState,
        TypeDocument typeDocument,
        Long documentNumber,
        boolean isBachiller,
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
            isBachiller,
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
            Constants.genders.get(json.get("gender")),
            json.get("address"),
            Constants.civilStates.get(json.get("civil_state")),
            Constants.typeDocuments.get(json.get("type_document")),
            Long.parseLong(json.get("document_number")),
            Boolean.parseBoolean(json.get("is_bachiller")),
            json.get("eps")
        );
    }

    public static Applicant getObj(List<Applicant> data, int id) throws Exception {
        Applicant selectedApplicant = null;

        for (Applicant applicant : data) {
            if (applicant.getId() == id) selectedApplicant = applicant;
        }

        if (selectedApplicant == null) {
            throw new Exception("There is no such applicant.");
        }

        return selectedApplicant;
    }

    @Override
    public Map<String, String> toJson(){
        Map<String, String> json = new TreeMap<String, String>();

        json.put("first_name", this.firstName);
        json.put("last_name", this.lastName);
        json.put("email", this.email);
        json.put("phone", this.phoneNumber.toString());
        json.put("gender", Constants.gendersInverse.get(this.gender));
        json.put("address", this.address);
        json.put("civil_state", Constants.civilStatesInverse.get(this.civilState));
        json.put("type_document", Constants.typeDocumentsInverse.get(this.typeDocument));
        json.put("document_number", this.documentNumber.toString());
        json.put("is_bachiller", String.valueOf(this.isBachiller));
        json.put("eps", this.nameEPS);

        return json;
    }

    @Override
    public String toString() {
        return String.format("Applicant(name=%s)", this.getFullName());
    }
}
