package src.models;

import java.util.*;

import src.constants.Constants;
import src.enums.*;
import src.interfaces.*;

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
        this.id = ++Student.countStudent;
        this.inscriptionState = InscriptionState.ADMITTED;
    }

    public Student(
        String firstName,
        String lastName,
        InscriptionState inscriptionState,
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
        this.id = ++Student.countStudent;
        this.inscriptionState = inscriptionState;
    }

    public static List<Student> fromJsonList(List<Map<String, String>> jsonList) {
        List<Student> students = new ArrayList<Student>();
        for (Map<String, String> json : jsonList) {
            students.add(Student.fromJson(json));
        }
        return students;
    }

    public static Student fromJson(Map<String, String> json) {
        return new Student(
            json.get("first_name"),
            json.get("last_name"),
            InscriptionState.ENROLLED,
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

    public static Student getObj(List<Student> data, int id) throws Exception {
        Student selectedStudent = null;
        for (Student student : data) {
            if (student.getId() == id) selectedStudent = student;
        }

        if (selectedStudent == null) {
            throw new Exception("There is no such student.");
        }

        return selectedStudent;
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
        return String.format("Student(name=%s)", this.getFullName());
    }
}
